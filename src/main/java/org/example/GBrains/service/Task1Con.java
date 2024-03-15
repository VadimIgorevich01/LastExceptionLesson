package org.example.GBrains.service;

import org.example.GBrains.model.RecordTask1;
import org.example.GBrains.model.RecordsBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task1Con implements TasksConsole {
    String[] requiredFields = new String[]{"Фамилия", "Имя", "Отчество", "ДатаРождения", "НомерТел", "Пол"};
    Boolean[] booleansFieldsResult = new Boolean[] {true, true, true, true, true, true};
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

    public int showNumFieldsRequired() {
        int counter = 0;
        for (int i = 0; i < booleansFieldsResult.length; i++) {
            if (booleansFieldsResult [i]) {
                ++counter;
            }
        }
        return counter;
    }
    public String initMessage = "Введите следующие данные, разделенные пробелом в заданном порядке: " +
            "\nФамилия Имя Отчество датаРождения номерТелефона пол";

    @Override
    public RecordsBase completeTask() {
        initialCheck(wasFirstIterationDone);
        while (howManyMistakes != 0) {
            try {
                if (wasFirstIterationDone) {
                    System.out.println("На данный момент наша запись:\n" + record.toString());
                    initialCheck(wasFirstIterationDone);
                }
                checkAllFields(recSplitInitial);
                System.out.println("Все отлично. Было введено: " + record);
                scanner.close();
            }
            catch (RuntimeException e) {
                mistakes = "";
                e.printStackTrace();
            }
        }
        return record;
    }
    public void initialCheck(boolean wasFirstIterationDone) {
        if (wasFirstIterationDone) {
        } else {
            System.out.println(initMessage);
        }
        String recordFrScanner = scanner.nextLine();
        recSplitInitial = recordFrScanner.split(" ");
        boolean isRecordWrong = isInitRecNotOkFunction(recSplitInitial);
        while (isRecordWrong) {
            System.out.println("Коды ошибок:\n1. Введено меньше, чем " + showNumFieldsRequired() +
            " значений\n2. Введено больше, чем " + showNumFieldsRequired() + " значений");
            System.out.println("Введите данные еще раз, которые указаны в RuntimeException в поле \"Введите заново\"");
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
        int fieldTurn = 0;
        for (int i = 0; i < booleansFieldsResult.length; i++) {
            if (booleansFieldsResult[i]) {
                isInputWrong(record[fieldTurn], i);
                ++fieldTurn;
            }
        }
        if (howManyMistakes > 0) {
            wasFirstIterationDone = true;
            throw new RuntimeException(mistakes);
        }
    }

    public void isInputWrong(String record, int mistakeIndex) {
        CheckFunctions checkString = new CheckString();
        CheckFunctions checkDate = new CheckDate();
        CheckFunctions checkPhone = new CheckPhoneNumber();
        CheckFunctions checkSex = new CheckSex();
        boolean isBadResult = true;
        Object fieldObj = "";
        int fieldCheckType = mistakeIndex;
        if (mistakeIndex == 0 || mistakeIndex == 1 || mistakeIndex == 2) {
            fieldCheckType = 0;
        }
        switch (fieldCheckType) {
            case (0):
                isBadResult = checkString.isMistake(record);
                fieldObj = record;
                break;
            case (3):
                isBadResult = checkDate.isMistake(record);
                if (!isBadResult) {
                    fieldObj = ((CheckDate) checkDate).getDate();
                }
                break;
            case (4):
                isBadResult = checkPhone.isMistake(record);
                if (!isBadResult) {
                    long fieldToBeSavedLong = Long.parseLong(record);
                    fieldObj = fieldToBeSavedLong;
                }
                break;
            case (5):
                isBadResult = checkSex.isMistake(record);
                fieldObj = record;
                break;
        }
        if (isBadResult) {
            String msg = " Введите заново: " + requiredFields[mistakeIndex] + ".\n";
            mistakes += msg;
            booleansFieldsResult [mistakeIndex] = true;
        } else {
            --howManyMistakes;
            if (this.record instanceof RecordTask1) {
                ((RecordTask1) this.record).set(mistakeIndex, fieldObj);
                System.out.println("Верный ввод " + requiredFields[mistakeIndex] + " : " + ((RecordTask1) this.record).get(mistakeIndex));
                booleansFieldsResult [mistakeIndex] = false;
            }
        }
    }
}
