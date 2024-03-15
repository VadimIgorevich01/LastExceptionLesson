package org.example.GBrains.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class RecordTask1 extends RecordsBase{

    String name;
    String patronymic;
    Date birthDate;
    String birthDateStr;
    long number;

    public RecordTask1(String sureName, String name, String patronymic, Date birthDate, long number, String sex) {
        super(sureName, sex);
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.number = number;
    }

    public RecordTask1() {
        super();
        this.name = "НеверноИмя";
        this.patronymic = "НеверноОтчество";
        Date birthday = new Date(00, 0, 0);
        this.birthDate = birthday;
        this.number = 00000000000L;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        birthDateStr = formatter.format(birthDate);

        Date MistakeBirthday = new Date(00, 00, 00);
        if (Objects.equals(birthDate, MistakeBirthday)) {
            birthDateStr = "НеверноДата";
        }

        return "<" + super.getSureName() + ">  <" + this.name + ">  <" + this.patronymic + ">  <" + this.birthDateStr + ">  <" + this.number + ">  <" + super.getSex() + ">";
    }

    public void set(int fieldNumber, Object fieldToBeSavedObj) {
        String fieldToBeSavedStr;
        long fieldToBeSavedLong;
        Date fieldToBeSavedDate;
        switch (fieldNumber) {
            case (0):
                fieldToBeSavedStr = (String) fieldToBeSavedObj;
                setSureName(makeGoodFormat(fieldToBeSavedStr));
                break;
            case (1):
                fieldToBeSavedStr = (String) fieldToBeSavedObj;
                this.name = makeGoodFormat(fieldToBeSavedStr);
                break;
            case (2):
                fieldToBeSavedStr = (String) fieldToBeSavedObj;
                this.patronymic = makeGoodFormat(fieldToBeSavedStr);
                break;
            case (3):
                fieldToBeSavedDate = (Date) fieldToBeSavedObj;
                this.birthDate = fieldToBeSavedDate;
                break;
            case (4):
                fieldToBeSavedLong = (long) fieldToBeSavedObj;
                this.number = fieldToBeSavedLong;
                break;
            case (5):
                fieldToBeSavedStr = (String) fieldToBeSavedObj;
                setSex(fieldToBeSavedStr);
                break;
        }
    }
    public Object get (int fieldNumber) {
        Object result = null;
        switch (fieldNumber) {
            case (0):
                result = getSureName();
                break;
            case (1):
                result = this.name;
                break;
            case (2):
                result = this.patronymic;
                break;
            case (3):
                result = this.birthDate;
                break;
            case (4):
                result = this.number;
                break;
            case (5):
                result = getSex();;
                break;
        }
        return result;
    }

    private String makeGoodFormat (String notFormatStr) {
        String notFormatLowerCase = notFormatStr.toLowerCase();
        char [] notFormatStrCharArr = notFormatLowerCase.toCharArray();
        notFormatStrCharArr [0] = Character.toUpperCase(notFormatStrCharArr [0]);
        String goodFormatStr = new String(notFormatStrCharArr);
        return goodFormatStr;
    }
}
