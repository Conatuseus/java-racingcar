package com.conatuseus.racingcar.appcontroller;

import com.conatuseus.racingcar.appview.AppView;

public class AppController {

    public AppController(){
    }


    public void run(){
        AppView.outputLine(">> 게임을 시작합니다.");

        AppView.outputLine("<< 게임을 종료합니다.");
    }

    private void inputAndMakeCarList(){
        String[] carsName=AppView.inputNameOfCar();


    }

}
