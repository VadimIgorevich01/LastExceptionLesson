package org.example.GBrains.service;

import org.example.GBrains.model.RecordsBase;

import java.io.FileWriter;
import java.io.IOException;

public class RecordToFile implements MakeRecord{
    @Override
    public void record(RecordsBase record) {
        String fileName = record.getSureName() + ".txt";
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, true);
            fw.write(record.toString());
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
