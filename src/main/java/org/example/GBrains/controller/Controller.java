package org.example.GBrains.controller;

import org.example.GBrains.model.RecordTask1;
import org.example.GBrains.model.RecordsBase;
import org.example.GBrains.service.MakeRecord;
import org.example.GBrains.service.RecordToFile;
import org.example.GBrains.service.Task1Con;
import org.example.GBrains.service.TasksConsole;

public class Controller {
    TasksConsole task1Con = new Task1Con();
    RecordsBase recordForTask1 = new RecordTask1();
    MakeRecord recordToFile = new RecordToFile();

    public void run() {
        recordForTask1 = task1Con.completeTask();
        recordToFile.record (recordForTask1);
    }
}
