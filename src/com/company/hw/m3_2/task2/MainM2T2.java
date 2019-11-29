package com.company.hw.m3_2.task2;

/*Распарсить следующую структуру данных:
*
* {
	"name": "John",
	"surname": "Smith",
	"phones": ["044-245-78-90", "066-123-45-67"],
	"sites": ["http://site1.com", "https://site2.com"],
	"address": {
		"country": "UA",
		"city": "Kyiv",
		"street": "Anri Barbusa"
	}
}*/

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class MainM2T2 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        String json = jsonFromFileToString(new File("D:\\my_files\\java\\java pro\\filesForTest\\contacts.json"));

        Contact contact = gson.fromJson(json, Contact.class);

        System.out.println(contact.getName() + ", " + contact.getSurname());
        System.out.println(contact);

    }

    private static String jsonFromFileToString(File file) {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
                while ((line = br.readLine()) != null)
                    sb.append(line);
                return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
