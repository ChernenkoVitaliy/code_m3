package com.company.examples.m2.sample1_gson;

/*
 * ccy	Код валюты (справочник кодов валют: https://ru.wikipedia.org/wiki/Коды_валют)
 * base_ccy	Код национальной валюты
 * buy	Курс покупки
 * sale	Курс продажи
*/

import com.google.gson.annotations.SerializedName;

public class Rate {
    private String ccy;
    @SerializedName(value = "base_ccy")
    private String baseCcy;
    private double buy;
    private double sale;


    public String getCcy() {
        return ccy;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public double getBuy() {
        return buy;
    }

    public double getSale() {
        return sale;
    }
}
