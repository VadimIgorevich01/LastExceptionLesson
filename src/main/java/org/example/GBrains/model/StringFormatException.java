package org.example.GBrains.model;

public class StringFormatException extends IllegalArgumentException{
    public StringFormatException() {
    }

    public StringFormatException(String s) {
        super(s);
    }

    public void showCause() {
        System.out.println("Строчка в неверном формате");
    }
}
