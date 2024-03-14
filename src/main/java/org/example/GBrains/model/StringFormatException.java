package org.example.GBrains.model;

public class StringFormatException extends IllegalArgumentException{

    public void showCause() {
        System.out.println("Строчка в неверном формате");
    }
}
