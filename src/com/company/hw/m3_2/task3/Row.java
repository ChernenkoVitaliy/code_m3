package com.company.hw.m3_2.task3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
public class Row {
    private String CCY;
    private String BaseCCY;
    private double buy;
    private double sale;

    //fix it


    public String getCCY() {
        return CCY;
    }

    @XmlAttribute(name = "ccy")
    public void setCCY(String CCY) {
        this.CCY = CCY;
    }

    public String getBaseCCY() {
        return BaseCCY;
    }

    @XmlAttribute(name = "bace_ccy")
    public void setBaseCCY(String baseCCY) {
        BaseCCY = baseCCY;
    }

    public double getBuy() {
        return buy;
    }

    @XmlAttribute
    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    @XmlAttribute
    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Row{" +
                "CCY='" + CCY + '\'' +
                ", BaseCCY='" + BaseCCY + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
