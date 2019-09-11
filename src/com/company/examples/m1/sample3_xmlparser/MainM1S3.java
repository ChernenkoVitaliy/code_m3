package com.company.examples.m1.sample3_xmlparser;

public class MainM1S3 {
    public static void main(String[] args) {
        SimpleXMLParser xml = new SimpleXMLParser("D:\\my_files\\java\\java pro\\filesForTest\\1.xml");
        String value = xml.get("catalog/book/author");
        System.out.println(value);
    }
}
