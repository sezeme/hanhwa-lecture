package com.sezeme.chap04.conditional.level02.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("1~10사이의 정수를 입력해 주세요.");
        while(true) {
            int num = sc.nextInt();

            if(num < 1 || num > 10) {
                System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
                continue;
            }

            if(num % 2 == 1){
                System.out.println("홀수다.");
            } else {
                System.out.println("짝수다.");
            }
            break;
        }
    }
}
