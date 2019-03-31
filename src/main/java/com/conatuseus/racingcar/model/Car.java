package com.conatuseus.racingcar.model;

public class Car {
    private static final int MAX_RANDOM=9;
    private static final int MIN_RANDOM=0;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }



}
