package com.sezeme.chap04.looping_and_branching.level02.normal;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        for(int i = 1; i <= num ; i++) {
            if(i % 2 == 0) {
                System.out.print("박");
            }
            else {
                System.out.print("수");
            }
        }
    }
}
