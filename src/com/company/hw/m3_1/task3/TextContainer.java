package com.company.hw.m3_1.task3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SaveToFile("D:\\my_files\\java\\java pro\\filesForTest\\save.txt")
public class TextContainer {
    private static String text = "";

    public TextContainer(String text) {
        this.text = text;
    }

    @SaveMethod
    public static void save(String path) {
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(text.getBytes());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
