package org.example.facade;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Retrieve Chuck Norris joke
        try {
            String joke = getJoke();
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            System.err.println("Error retrieving Chuck Norris joke: " + e.getMessage());
        }

        // Retrieve latest foreign exchange rates
        try {
            JSONObject rates = getCurrencyRates();
            System.out.println("Currency Rates: " + rates.toString());
        } catch (IOException | JSONException e) {
            System.err.println("Error retrieving currency rates: " + e.getMessage());
        }
    }

    private static String getJoke() throws Exception {
        JokeClient client = new JokeClient();
        return client.getRandomJoke();
    }

    private static JSONObject getCurrencyRates() throws IOException, JSONException {
        String apiUrl = "https://api.fxratesapi.com/latest";
        String attributeName = "rates";
        return (JSONObject) ApiFacade.getAttributeValueFromJson(apiUrl, attributeName);
    }
}