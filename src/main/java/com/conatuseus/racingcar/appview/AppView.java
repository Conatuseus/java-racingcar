/*
 *  @(#)AppView.java       2.00    2019/04/01
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package com.conatuseus.racingcar.appview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * AppView 클래스는 View를 담당하는 클래스
 * 이 클래스에는 사용자의 입출력과 관련된 메소드들이 있다.
 * 출력에 관한 메소드, 차 이름을 입력 메소드, 시도할 횟수 입력 메소드
 *
 * @version             2.00    2019년 4월 1일
 * @author              사명기
 */
public final class AppView {

    /* Scanner 변수 */
    private static final Scanner sc = new Scanner(System.in);

    /* String matches에 사용할 regex 정의해둠 */
    private static final String ALPHABET = "^[a-zA-Z]*$";

    /* 가능한 이름의 최대 길이 저장 */
    private static final int VALID_NAME_LENGTH = 5;

    private AppView() {
    }

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static void output(String aString) {
        System.out.print(aString);
    }

    public static String[] inputNameOfCar() {
        String[] scannedName;
        while (true) {
            outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            scannedName = sc.nextLine().split(",");

            if (isNamesValid(scannedName)) {
                return scannedName;
            }
            outputLine("잘못 입력하였습니다.(5글자 이하 영문자, 중복되지 않는 이름을 입력하세요)");
        }
    }

    public static boolean isNamesValid(String[] scannedName) {
        for (String name : scannedName) {
            if ((name.length() > VALID_NAME_LENGTH) || (!name.matches(ALPHABET))) {
                return false;
            }
        }
        return !isContains(scannedName);
    }

    private static boolean isContains(String[] scannedName) {
        Set<String> hashSet = new HashSet<>();
        for (String name : scannedName) {
            if (hashSet.contains(name)) {
                return true;
            }
            hashSet.add(name);
        }
        return false;
    }

    public static int inputNumberOfTry() {
        outputLine("시도할 횟수는 몇회인가요?");
        String scannedNumberOfTry;

        while (true) {
            scannedNumberOfTry = sc.nextLine();

            if (scannedNumberOfTry.matches("[0-9]*$")) {
                return Integer.parseInt(scannedNumberOfTry);
            }
            outputLine("잘못된 입력입니다. 정수만 입력하세요.");
        }
    }
}
