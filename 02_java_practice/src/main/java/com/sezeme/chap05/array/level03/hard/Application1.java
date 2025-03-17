package com.sezeme.chap05.array.level03.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 입력하세요 : ");
        int num = sc.nextInt();

        if(num % 2 == 0 || num <= 0) {
            System.out.println("양수 혹은 홀수만 입력해야합니다.");
            return;
        }

        int[] iarr = new int[num];
        int source = 1;
        for(int i = 0 ; i < num ; i++){
            iarr[i] = source;
            if(i < num/2) source++;
            else source--;
        }

        /*
            int mid = input / 2;

    for(int i = 0; i <= mid; i++) {
        arr[i] = i + 1;
        arr[input- i - 1] = i + 1;
    }
         */

        for(int i : iarr) {
            System.out.print(i + " ");
        }
    }
}
