package com.conatuseus.racingcar.model;


public class Car {
    private static final int MAX_RANDOM=9;
    private static final int MIN_RANDOM=0;
    private static final int CAN_GOING=4;

    private final String name;
    private int position = 0;
    private String result;

    public Car(String name) {
        this.name = name;
        this.result = this.name +" : ";
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void addRandomNumToPosition(){
        int random=(int)(Math.random()*MAX_RANDOM) + MIN_RANDOM;
        if(this.isGoingPossible(random)){
            this.position+=random;
        }
    }

    private boolean isGoingPossible(int random){
        return random >= CAN_GOING;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder(this.result);
        int goingLength= this.getPosition()- (this.result.length()-this.name.length()-3);   // 추가된 거리 = 현재위치 - (이전거리-이름길이-3)
        for(int i=0; i<goingLength; i++){
            sb.append("-");
        }
        return sb.toString();
    }

}
