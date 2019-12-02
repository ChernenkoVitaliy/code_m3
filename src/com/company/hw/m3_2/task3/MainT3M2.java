package com.company.hw.m3_2.task3;

/*Написать парсер для Privat Finance API в режиме XMl(+)*

https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5/
 */


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;

public class MainT3M2 {
    public static void main(String[] args) throws IOException, JAXBException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        URL url1 = new URL(url);

        JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRateXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        ExchangeRateXML exchangeRate = (ExchangeRateXML) unmarshaller.unmarshal(url1);

        System.out.println(exchangeRate);

    }
}
