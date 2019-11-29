package com.company.hw.m3_2.task3;

/*Написать парсер для Privat Finance API в режиме XMl*

https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5/
 */

import com.company.examples.m1.sample5_jaxb.Catalog;
import com.sun.jndi.toolkit.url.UrlUtil;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainT3M2 {
    public static void main(String[] args) throws IOException, JAXBException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        String xml = performRequest(url);

        JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRate.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        URL url1 = new URL(url);
        ExchangeRate exchangeRate = (ExchangeRate) unmarshaller.unmarshal(url1);

        System.out.println(exchangeRate);

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
