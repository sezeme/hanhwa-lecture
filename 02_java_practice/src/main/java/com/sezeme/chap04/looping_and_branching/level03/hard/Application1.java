package com.sezeme.chap04.looping_and_branching.level03.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;
        boolean flag = true;
        while (true) {
            System.out.print("2보다 큰 정수를 하나 입력하세요 : ");
            num = sc.nextInt();
            if(num < 2) {
                System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
                continue;
            }
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("소수다.");
            else System.out.println("소수가 아니다.");

            break;
        }
    }
}
