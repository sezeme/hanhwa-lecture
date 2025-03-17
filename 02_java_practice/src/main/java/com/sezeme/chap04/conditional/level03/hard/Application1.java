package com.sezeme.chap04.conditional.level03.hard;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 정수 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 정수 : ");
        int num2 = sc.nextInt();

        sc.nextLine();

        System.out.print("연산 기호(+,-,*,/,%)를 입력하세요 : ");
        String op = sc.nextLine();

        try {
            switch (op.charAt(0)) {
                case '+' -> {
                    System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
                }
                case '-' -> {
                    System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
                }
                case '*' -> {
                    System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
                }
                case '/' -> {
                    System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
                }
                case '%' -> {
                    System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));
                }
                default -> {
                    throw new IllegalArgumentException("입력하신 연산은 없습니다. 프로그램을 종료합니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }
    }
}
