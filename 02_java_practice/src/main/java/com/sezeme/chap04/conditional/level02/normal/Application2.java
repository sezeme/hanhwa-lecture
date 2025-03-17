package com.sezeme.chap04.conditional.level02.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double weight, height;
        System.out.print("당신의 체중(kg) : ");
        weight = sc.nextDouble();
        System.out.print("당신의 신장(m) : ");
        height = sc.nextDouble();
        double bmi = weight / (height * height);

        if(bmi < 20) System.out.println("당신은 저체중 입니다.");
        else if(bmi < 25) System.out.println("당신은 정상체중 입니다.");
        else if(bmi < 30) System.out.println("당신은 과체중 입니다.");
        else System.out.println("당신은 비만 입니다.");



    }
}
