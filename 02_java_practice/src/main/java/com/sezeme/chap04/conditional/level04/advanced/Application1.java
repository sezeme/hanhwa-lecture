package com.sezeme.chap04.conditional.level04.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int kor, eng, math;
        System.out.print("국어 점수를 입력하세요 : ");
        kor = sc.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        eng = sc.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        math = sc.nextInt();

        System.out.println("\n");


        int avg = (kor + eng + math) / 3;
        boolean isAvgPass = avg >= 60;
        boolean isKorPass = kor >= 40;
        boolean isEngPass = eng >= 40;
        boolean isMathPass = math >= 40;


        if(isAvgPass && isKorPass && isEngPass && isMathPass) {
            System.out.println("합격입니다!");
        } else {
            if(!isAvgPass) {
                System.out.println("평균점수 미달로 불합격 입니다.");
            }

            if(!isKorPass) {
                System.out.println("국어점수 미달로 불합격 입니다.");
            }

            if(!isEngPass) {
                System.out.println("영어점수 미달로 불합격 입니다");
            }

            if(!isMathPass) {
                System.out.println("수학점수 미달로 불합격 입니다");
            }
        }
    }
}
