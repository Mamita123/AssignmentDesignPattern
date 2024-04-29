package org.example.facade;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyRateFacadeRate {

    public static void main(String[] args) {
        String apiUrl = "https://api.fxratesapi.com/latest";
        String attributeName = "rates"; // Update attribute name if needed

        try {
            JSONObject rates = (JSONObject) ApiFacade.getAttributeValueFromJson(apiUrl, attributeName);
            System.out.println("Rates: " + rates.toString());
        } catch (IOException | JSONException e) {
            System.err.println("Error retrieving rates: " + e.getMessage());
        }
    }
}
