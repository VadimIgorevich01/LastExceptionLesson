package org.example.GBrains.controller;

import org.example.GBrains.service.Task1Con;
import org.example.GBrains.service.TasksConsole;

public class Controller {
    TasksConsole task1Con = new Task1Con();
    public void run() {
        task1Con.completeTask();
    }
}
