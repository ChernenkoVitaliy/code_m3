package com.company.hw.m3_1.task3;

/*Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
*   1. в какой файл должен сохраниться текст
*   2. метод, который выполнит сохранение.
*
* Написать класс Saver, который сохранит набор объектов TextContainer в разные файлы.(+)*/

public class MainM1T3 {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer("Some Text1");

        Saver.save(textContainer.getClass());
    }
}

