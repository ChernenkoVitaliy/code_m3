package com.company.examples.m1.sample5_jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement(name = "book")
public class Book {

    private String author;
    private String title;
    private double price;
    private Date publishDate;

    public Book() {
    }

    public Book(String author, String title, double price, Date publishDate) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String toString() {
        return "[" + author + ", " + title + ", " + price + ", " + publishDate + "]";
    }

    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement(name = "pulish_date")
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Date getPublishDate() {
        return publishDate;
    }
}
