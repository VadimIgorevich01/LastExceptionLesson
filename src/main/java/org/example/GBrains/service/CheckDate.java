package org.example.GBrains.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDate implements CheckFunctions {
    private Date date;

    public Date getDate() {
        return date;
    }

    @Override
    public boolean isMistake(String objToBeChecked) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        try {
            int testInt = Integer.parseInt(objToBeChecked);
            date = formatter.parse(objToBeChecked);
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }
}
