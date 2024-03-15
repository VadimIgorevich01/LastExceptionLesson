package org.example.GBrains.service;

public class CheckPhoneNumber implements CheckFunctions{
    @Override
    public boolean isMistake(String fieldForChecking) {
        try {
            long testLong = Long.parseLong(fieldForChecking);
            char[] fieldChar = fieldForChecking.toCharArray();
            int howManyFiguresReq = 11;
            if (fieldChar.length != howManyFiguresReq) {
                int throwException = Integer.parseInt("89644430325");
            }
            return false;
        } catch (NumberFormatException e) {
            try {
                throw new NumberFormatException("Введите номер телефон в формате: 89644430325");
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                return true;
            }
        }
    }
}
