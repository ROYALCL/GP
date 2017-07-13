package org.jlxy.cmm.utils;

/**
 * Created by ORCHID on 2017/4/2.
 */
public enum BOOLEAN {
    TRUE("T", "TRUE"), FALSE("F", "FALSE"), SECRECY("S", "SECRECY");
    private String key;
    private String value;

    BOOLEAN(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public boolean getTRUE(){
        return Boolean.parseBoolean(BOOLEAN.TRUE.getKey());
    }

    public boolean getFALSE(){
        return Boolean.parseBoolean(BOOLEAN.FALSE.getKey());
    }
}
