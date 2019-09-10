package com.company.m1.sample5_createxml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class MainM1S5 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("catalog");
            document.appendChild(rootElement);

            //book1
            Element book1 = document.createElement("book1");
            rootElement.appendChild(book1);

            Element author1 = document.createElement("author");
            author1.setTextContent("Some Author");
            book1.appendChild(author1);

            //book2
            Element book2 = document.createElement("book2");
            rootElement.appendChild(book2);

            Element author2 = document.createElement("author");
            author2.setTextContent("Another Author");
            book2.appendChild(author2);


            //save
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("D:\\my_files\\java\\java pro\\filesForTest\\3.xml"));

            transformer.transform(source, result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
