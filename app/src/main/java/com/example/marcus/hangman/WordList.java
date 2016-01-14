package com.example.marcus.hangman;

import java.util.ArrayList;

/**
 * Created by Marcus on 14.01.2016.
 */
public class WordList {

    private ArrayList<Wort> woerter = new ArrayList<Wort>();

    public WordList() {

        woerter.add(new Wort("LAND", "DEUTSCHLAND"));
        woerter.add(new Wort("LAND", "SPANIEN"));
        woerter.add(new Wort("LAND", "ENGLAND"));
        woerter.add(new Wort("LAND", "ITALIEN"));
        woerter.add(new Wort("LAND", "SCHWEIZ"));
        woerter.add(new Wort("LAND", "RUSSLAND"));
        woerter.add(new Wort("LAND", "POLEN"));
        woerter.add(new Wort("LAND", "BRASILIEN"));
        woerter.add(new Wort("LAND", "ARGENTINIEN"));
        woerter.add(new Wort("LAND", "BELGIEN"));
        woerter.add(new Wort("LAND", "AUSTRALIEN"));
        woerter.add(new Wort("LAND", "NIEDERLANDE"));
        woerter.add(new Wort("LAND", "PORTUGAL"));
        woerter.add(new Wort("LAND", "NIGERIA"));
        woerter.add(new Wort("LAND", "CHINA"));


    }

    public Wort getRandomWord() {
        return woerter.get((int) (Math.random() * woerter.size()));
    }
}
