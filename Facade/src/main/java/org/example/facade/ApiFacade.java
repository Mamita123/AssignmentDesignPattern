package org.example.facade;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {

    public static Object getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException, JSONException {

        String jsonResult = getJsonFromApi(urlString);
        JSONObject jsonObject = parseJson(jsonResult);

        return getAttributeValue(jsonObject, attributeName);
    }

    private static String getJsonFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        StringBuilder response = new StringBuilder();
        while ((output = br.readLine()) != null) {
            response.append(output);
        }

        conn.disconnect();
        return response.toString();
    }

    private static JSONObject parseJson(String json) throws JSONException {
        return new JSONObject(json);
    }

    private static Object getAttributeValue(JSONObject jsonObject, String attributeName) throws JSONException {
        if (jsonObject.has(attributeName)) {
            Object attributeValue = jsonObject.get(attributeName);
            return attributeValue;
        } else {
            throw new IllegalArgumentException("Attribute not found: " + attributeName);
        }
    }
}