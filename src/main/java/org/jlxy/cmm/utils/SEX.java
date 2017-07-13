package org.jlxy.cmm.utils;

/**
 * Created by ORCHID on 2017/4/2.
 */
public enum SEX {
    /**
     *
     */
    MALE("M", "MALE"), FEMALE("F", "FEMALE"), SECRECY("S", "SECRECY");
    private String key;
    private String value;

    SEX(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
