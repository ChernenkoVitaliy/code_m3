package com.company.m1.sample3_xmlparser;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class SimpleXMLParser {
    private String xml;

    public SimpleXMLParser(String path){
        byte[] buf = null;

        try{
            RandomAccessFile file = new RandomAccessFile(path, "r");
            try {
                buf = new byte[(int) file.length()];
                file.read(buf);
            }finally {
                file.close();
            }
        }catch (IOException e){}

        try {
            xml = new String(buf, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //"catalog/book/author"
    public String get(String path) {
        String[] parts = path.split("/");
        String s_xml = xml;

        for (String s : parts) {
            String toFind = "<" + s + ">";

            int start = s_xml.indexOf(toFind);
            if (start < 0)
                return null;
            else
                start += toFind.length();

            int end = s_xml.lastIndexOf("</" + s + ">");
            if (end < 0)
                return null;

            s_xml = s_xml.substring(start, end);
        }

        return s_xml;
    }
}
