package org.example.GBrains.service;

import org.example.GBrains.model.StringFormatException;

public class CheckString implements CheckFunctions {

    String allowedChars = "йцукенгшщзхъфывапролджэячсмитьбюё";
    char [] allowedCharsArr = allowedChars.toCharArray();
    @Override
    public boolean isMistake(String fieldForChecking) {
        String lowerCaseStr = fieldForChecking.toLowerCase();
        char [] strToBeChecked = lowerCaseStr.toCharArray();
        boolean noMatches = true;
        try {
            for (int i = 0; i < strToBeChecked.length; i++) {
                for (int j = 0; j < allowedCharsArr.length; j++) {
                    if (strToBeChecked[i] == allowedCharsArr[j]) {
                        j = allowedCharsArr.length;
                        noMatches = false;
                    }
                }
                if (noMatches) {
                    throw new StringFormatException("В строке могут быть только русские буквы, например, Вадим");
                }
                noMatches = true;
            }
            return false;
        } catch (StringFormatException e) {
            e.printStackTrace();
            return true;
        }

    }

}
