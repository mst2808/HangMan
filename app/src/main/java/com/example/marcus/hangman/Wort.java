package com.example.marcus.hangman;

/**
 * Created by Marcus on 14.01.2016.
 */
public class Wort {

    private String category;
    private String value;

    public Wort(String category, String value) {
        this.category = category;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }
}
