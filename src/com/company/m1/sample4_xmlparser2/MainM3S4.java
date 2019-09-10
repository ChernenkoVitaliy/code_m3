package com.company.m1.sample4_xmlparser2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class MainM3S4 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("D:\\my_files\\java\\java pro\\filesForTest\\2.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(xmlFile);

            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());
            System.out.println("-----------------------------------");

            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i ++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println("Book: ");

                    System.out.println("Author: " + element.getElementsByTagName("author").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("Title: " + element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("------------------------------------");
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
