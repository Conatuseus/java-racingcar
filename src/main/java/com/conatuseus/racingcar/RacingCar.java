/*
 *  @(#)RacingCar.java       2.00    2019/04/01
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package com.conatuseus.racingcar;

import com.conatuseus.racingcar.appcontroller.AppController;

/**
 * 자동차 게임의 Main 클래스
 * appController 객체를 생성해서, run 함수 실행
 */
public class RacingCar {
    public static void main(String[] args) {
        AppController appController = new AppController();
        appController.run();
    }
}
