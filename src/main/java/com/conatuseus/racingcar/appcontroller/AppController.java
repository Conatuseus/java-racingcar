/*
 *  @(#)AppController.java       2.00    2019/04/01
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package com.conatuseus.racingcar.appcontroller;

import com.conatuseus.racingcar.appview.AppView;
import com.conatuseus.racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

/**
 * MCV 패턴에서 Controller에 해당하는 클래스
 * AppView 클래스와 Car클래스와 연결되서 많은 작업을 한다.
 * 자동차 이름을 입력받는 메소드, 레이싱을 1회 수행하는 메소드
 * 레이싱을 시도할 횟수만큼 수행하는 메소드, 우승자를 찾아 출력하는 메소드
 * 위의 메소드를 사용해 실행 로직을 담당하는 메소드가 있다.
 *
 * @version             2.00    2019년 4월 1일
 * @author              사명기
 */
public class AppController {

    /* Car객체들을 저장하기 위한 List */
    public static List<Car> carList = new ArrayList<>();

    /* 시도할 횟수를 저장할 변수 */
    private int numberOfTry;

    /* 우승자의 position을 저장할 변수 */
    private int maxPosition=0;

    /* numberOfTry(시도할 횟수)의 getter */
    private int getNumberOfTry() {
        return numberOfTry;
    }

    /* numberOfTry(시도할 횟수)의 setter */
    private void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    /* maxPosition(가장 큰 position)의 getter */
    private int getMaxPosition() {
        return maxPosition;
    }

    /* maxPosition(가장 큰 position)의 setter */
    private void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    /* AppController class의 생성자.  */
    public AppController() {
    }

    /*
    * run 메소드는 게임을 순차적으로 실행하기 위한 메소드
    * 자동차 이름 입력, 시도할 횟수 입력, 실행 결과  를 순차적으로 실행한다.
    */
    public void run() {
        AppView.outputLine(">> 게임을 시작합니다.");

        this.inputNameAndMakeCarList();                             //  자동차 이름 입력받는 메소드 실행
        this.setNumberOfTry(AppView.inputNumberOfTry());        //  시도할 횟수 입력받는 메소드 실행

        AppView.outputLine("실행결과");
        racingNumberOfTry(this.getNumberOfTry());               //  시도할 횟수만큼 racing 진행 메소드 실행
        this.printWinner(this.getMaxPosition());                //  우승한 자동차 이름 출력하는 메소드 실행

        AppView.outputLine("<< 게임을 종료합니다.");
    }

    /*
    * 자동차
    * */
    private void inputNameAndMakeCarList() {
        String[] carsName = AppView.inputNameOfCar();

        for (String name : carsName) {
            carList.add(new Car(name));
        }
    }

    private void racingOneStep(int step) {
        for (Car car : carList) {
            car.addRandomNumToPosition();
//            AppView.outputLine(car.getPosition()+"");   // position과 - 이 맞는지 보기위한 코드
            AppView.outputLine(car.toString());
            if (step == (this.getNumberOfTry() - 1)) {
                this.setMaxPosition(Integer.max(this.getMaxPosition(), car.getPosition()));      // 마지막 Step이면 maxPosition 검사해서 저장
            }
        }
    }

    private void racingNumberOfTry(int numberOfTry) {
        for (int step = 0; step < numberOfTry; step++) {
            racingOneStep(step);
            AppView.outputLine("");
        }
    }

    private void printWinner(int maxPosition) {
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                AppView.output(car.getName() + " ");
            }
        }
        AppView.outputLine("가 최종 우승했습니다.");
    }
}
