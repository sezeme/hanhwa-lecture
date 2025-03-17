package com.sezeme.chap10.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("분자 입력 : ");
            int son = sc.nextInt();
            System.out.print("분모 입력 : ");
            int mother = sc.nextInt();

            int result = son / mother;
            System.out.println("결과 : " + result);
        } catch (InputMismatchException e) {
            System.out.println("오류 : 유효한 정수를 입력하세요.");
        } catch (ArithmeticException e) {
            System.out.println("오류 : 0으로 나누는 것은 허용되지 않습니다.");
        }

        System.out.println("실행이 완료되었습니다.");
    }
}
