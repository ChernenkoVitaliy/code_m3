package com.company.hw.m3_2.task3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
public class Row {
    private ExchangeRate exchangeRate;

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    @XmlElement(name = "exchangerate")
    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }


    @Override
    public String toString() {
        return "Row{" +
                "exchangeRate=" + exchangeRate +
                '}';
    }
}
