package org.example.GBrains.service;

import org.example.GBrains.model.RecordTask1;
import org.example.GBrains.model.RecordsBase;

import java.util.Scanner;

public class Task1Con implements TasksConsole {
    int requiredFieldsNumber = 6;
    String[] requiredFields = new String[]{"Фамилия", "Имя", "Отчество", "ДатаРождения", "НомерТел", "Пол"};
    Boolean[] booleansFieldsResult = new Boolean[] {true, true, true};
    RecordsBase record = new RecordTask1();
    boolean wasFirstIterationDone = false;
    int sureName = 0;
    int name = 1;
    int patronymic = 2;
    int birthDate = 3;
    int numberTel = 4;
    int sex = 5;
    public int howManyMistakes = booleansFieldsResult.length;
    public String mistakes = "";
    public boolean isSureNameWrong = true;
    public boolean isNameWrong = true;
    public boolean isPatronymicWrong = true;
    Scanner scanner = new Scanner(System.in);
    String[] recSplitInitial;
    public String troubleshootingInfo = "Коды ошибок:\n1. Введено меньше, чем " + requiredFieldsNumber +
            " значений\n2. Введено больше, чем " + requiredFieldsNumber + " значений";

    public String initMessage = "Введите следующие данные, разделенные пробелом в заданном порядке: " +
            "\nФамилия Имя Отчество датаРождения номерТелефона пол";

    @Override
    public void completeTask() {
        initialCheck(wasFirstIterationDone);
        while (howManyMistakes != 0) {
            try {
                if (wasFirstIterationDone) {
                    System.out.println("На данный момент наша запись:\n" + record.toString());
                    initialCheck(wasFirstIterationDone);
                    //recSplitCurrent = recSplitNew;
                }
                checkAllFields(recSplitInitial);
                System.out.println("Все отлично. Было введено: " + record);
                scanner.close();
                //howManyMistakes = 0;
            }
            catch (RuntimeException e) {
                mistakes = "";
                e.printStackTrace();
            }
        }
    }
    public void initialCheck(boolean wasFirstIterationDone) {
        if (wasFirstIterationDone) {
            System.out.println("Введите заново следующие поля: ");
            for (int i = 0; i < booleansFieldsResult.length; i++) {
                if (booleansFieldsResult[i]) {
                    System.out.printf(requiredFields[i] + " ");
                }
            }
        } else {
            System.out.println(initMessage);
        }

        String recordFrScanner = scanner.nextLine();
        recSplitInitial = recordFrScanner.split(" ");
        boolean isRecordWrong = isInitRecNotOkFunction(recSplitInitial);
        while (isRecordWrong) {
            System.out.println(troubleshootingInfo);
            System.out.println(initMessage);
            recordFrScanner = scanner.nextLine();
            recSplitInitial = recordFrScanner.split("\\s");
            isRecordWrong = isInitRecNotOkFunction(recSplitInitial);
        }
    }

    public boolean isInitRecNotOkFunction(String[] initRecSplit) {
        int counterReqFields = 0;
        for (int i = 0; i < booleansFieldsResult.length; i++) {
            if (booleansFieldsResult[i]) {
                ++counterReqFields;
            }
        }
        if (initRecSplit.length < counterReqFields) {
            System.out.println("Код ошибки 1");
            return true;
        } else if (initRecSplit.length > counterReqFields) {
            System.out.println("Код ошибки 2");
            return true;
        } else {
            System.out.println("Введено " + initRecSplit.length + " значений из " + counterReqFields +
                    "\n" + "Начата проверка..");
            return false;
        }
    }
    private void checkAllFields(String [] record) {
        int mistakeIndex = booleansFieldsResult.length + 1;;
        int fieldCheckType = booleansFieldsResult.length + 1;
        int fieldTurn = 0;
        for (int i = 0; i < booleansFieldsResult.length; i++) {
            if (booleansFieldsResult[i]) {
                mistakeIndex = i;
            }
            if (mistakeIndex < 3) {
                fieldCheckType = 0;
            } else {
                fieldCheckType = mistakeIndex;
            }
            switch (fieldCheckType) {
                case (0):
                    isStringWrong(record[fieldTurn], mistakeIndex);
                    ++fieldTurn;
                    break;
//                case (3):
//                    isStringWrong(recSplitNew[fieldTurn], fieldTurn);
//                    ++fieldTurn;
//                    break;
//                case (2):
//                    isStringWrong(recSplitNew[fieldTurn], fieldTurn);
//                    ++fieldTurn;
//                    break;
//                case (3):
//                    isStringWrong(recSplitNew[fieldTurn], fieldTurn);
//                    ++fieldTurn;
//                    break;
            }

            mistakeIndex = booleansFieldsResult.length + 1;;
            fieldCheckType = booleansFieldsResult.length + 1;
        }
        if (howManyMistakes > 0) {
            wasFirstIterationDone = true;
            throw new RuntimeException(mistakes);
        }
    }

    public void isStringWrong(String strToBeChecked, int field) {
        CheckFunctions checkString = new CheckString();
        if (checkString.isMistake(strToBeChecked)) {
            String msg = " Неверный ввод: " + requiredFields[field] + ".\n";
            mistakes += msg;
            booleansFieldsResult [field] = true;
        } else {
            --howManyMistakes;
            if (record instanceof RecordTask1) {
                ((RecordTask1) record).set(field, strToBeChecked);
                System.out.println("Верный ввод " + requiredFields[field] + " : " + ((RecordTask1) record).get(field));
                booleansFieldsResult [field] = false;
            }
        }
    }
}
