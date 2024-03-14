package org.example.GBrains;


import org.example.GBrains.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
        // добавил проверку по дате и код перестал работать, если ввести Пр1о вад ИгОр 01031995 и потом ввести фамилию снова с ошибкой, то почему-то вроде как booleansFieldsResult отрабатывает только с одним значением хуй знает надо заново смотреть почему так после проверять дату рождения на ошибки ввода, добавить проверку телефона, пола и в конце концов еще и записывать в файл
    }
}