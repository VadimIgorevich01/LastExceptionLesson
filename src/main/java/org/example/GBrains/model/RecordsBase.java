package org.example.GBrains.model;

public abstract class RecordsBase {
    private String sureName;

    private String sex;

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex.toLowerCase();
    }

    public RecordsBase(String sureName, String sex) {
        this.sureName = sureName;
        this.sex = sex;
    }

    public RecordsBase() {
        this.sureName = "НеверноФамиля";
        this.sex = "НеверноПол";
    }
}
