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
    public boolean isMistake(String fieldForChecking) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        int howManyDigitsInDate = 6;
        try {
            int testInt = Integer.parseInt(fieldForChecking);
            date = formatter.parse(fieldForChecking);
            char [] obj = fieldForChecking.toCharArray();
            if (obj.length != howManyDigitsInDate) {
                throw new NumberFormatException("Для даты нужно 6 цифр. Например, 010395, значит 1 марта 1995 года");
            }
            return false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }
}
