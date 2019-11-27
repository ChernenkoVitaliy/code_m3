package com.company.examples.m2.sample1_gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainM2S1 {
    public static void main(String[] args) throws IOException {
        String request = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        String result = performRequest(request);

        Gson gson = new GsonBuilder().create();

        Rate[] rates = gson.fromJson(result, Rate[].class);

        for (Rate rate : rates) {
            System.out.println("CCY: " + rate.getCcy());
            System.out.println("BASE_CCY: " + rate.getBaseCcy());
            System.out.println("BUY: " + rate.getBuy());
            System.out.println("SALE: " + rate.getSale());
            System.out.println();
        }


        System.out.println("JSON: \n\t" + gson.toJson(rates));
    }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1_000_000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            }while (r > 0);
        }finally {
            http.disconnect();
        }

        return sb.toString();
    }
}
