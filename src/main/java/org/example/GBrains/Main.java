package org.example.GBrains;


import org.example.GBrains.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
        // добавить проверку телефона, пола и в конце концов еще и записывать в файл
    }
}