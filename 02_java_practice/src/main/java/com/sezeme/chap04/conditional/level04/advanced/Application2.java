package com.sezeme.chap04.conditional.level04.advanced;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary, profit, bonus, bonusAmount, totalSalary;
        System.out.print("월 급여 입력 : ");
        salary = sc.nextInt();
        System.out.print("매출액 입력 : ");
        profit = sc.nextInt();

        //set bonus
        if(profit >= 50000000) bonus = 5;
        else if(profit >= 30000000) bonus = 3;
        else if(profit >= 10000000) bonus = 1;
        else bonus = 0;

        bonusAmount = (int)(profit * (bonus/100.0));
        totalSalary = salary + bonusAmount;

        System.out.println("==================");
        System.out.println("매출액 : " + profit);
        System.out.println("보너스율 : " + bonus + "%");
        System.out.println("월 급여 : " + salary);
        System.out.println("보너스 금액 : " + bonusAmount);
        System.out.println("==================");
        System.out.println("총 급여 : " + totalSalary);


    }
}
