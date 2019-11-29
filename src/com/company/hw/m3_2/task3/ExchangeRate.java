package com.company.hw.m3_2.task3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "exchangerates")
public class ExchangeRate {
    private Row row[];

    public Row[] getRow() {
        return row;
    }

    @XmlElement(name = "row")
    public void setRow(Row[] row) {
        this.row = row;
    }


    @Override
    public String toString() {
        return "ExchangeRate{" +
                "row=" + Arrays.toString(row) +
                '}';
    }
}
