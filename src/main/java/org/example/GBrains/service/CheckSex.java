package org.example.GBrains.service;

import org.example.GBrains.model.SexFormatException;

public class CheckSex implements CheckFunctions{
    @Override
    public boolean isMistake(String fieldForChecking) {
        int allowedLength = 1;
        String allowedChar = "f";
        String allowedChar2 = "m";
        try {
            if (allowedLength != fieldForChecking.length()) {
                throw new SexFormatException("Введите одну латинскую букву f или m");
            }
            String lowerCaseField = fieldForChecking.toLowerCase();
            if (lowerCaseField.equals(allowedChar) || lowerCaseField.equals(allowedChar2)) {
                return false;
            } else {
                throw new SexFormatException("Введите латинскую букву f или m");
            }
        } catch (SexFormatException e) {
            e.printStackTrace();
            return true;
        }
    }
}
