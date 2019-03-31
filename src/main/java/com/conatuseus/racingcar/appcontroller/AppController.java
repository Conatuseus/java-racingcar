package com.conatuseus.racingcar.appcontroller;

import com.conatuseus.racingcar.appview.AppView;
import com.conatuseus.racingcar.model.Car;

import java.util.ArrayList;

public class AppController {

    public static ArrayList<Car> carList=new ArrayList<>();
    private int numberOfTry;

    public int getNumberOfTry() {
        return numberOfTry;
    }

    private void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public AppController(){
    }


    public void run(){
        AppView.outputLine(">> 게임을 시작합니다.");

        this.inputAndMakeCarList();
        this.setNumberOfTry(AppView.inputNumberOfTry());

        AppView.outputLine("실행결과");
        this.carsGoingOneStep();

        AppView.outputLine("<< 게임을 종료합니다.");
    }

    private void inputAndMakeCarList(){
        String[] carsName=AppView.inputNameOfCar();

        for(String name : carsName){
            carList.add(new Car(name));
        }
    }

    private void carsGoingOneStep(){

        for(Car car : carList){
            car.addRandomNumToPosition();
            AppView.outputLine(car.getPosition()+"");       // Car의 position과 출력이 잘 되는지 비교하기 위한 코드
            AppView.outputLine(car.toString());
        }
    }


}
