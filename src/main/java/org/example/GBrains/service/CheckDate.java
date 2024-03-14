package org.example.GBrains.service;

public class CheckDate implements CheckFunctions {

    @Override
    public boolean isMistake(Object objToBeChecked) {
        try {
            String getNumStr = (String) objToBeChecked;
            int getNum = Integer.parseInt(getNumStr);
            return false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return true;
        }
    }
}
