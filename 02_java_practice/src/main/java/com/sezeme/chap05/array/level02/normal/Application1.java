package com.sezeme.chap05.array.level02.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 하나 입력하세요 : ");
        String str = sc.nextLine();

        char[] carr = str.toCharArray();

        System.out.print("검색할 문자를 입력하세요 : ");
        char targetChar = sc.next().charAt(0);

        int count = 0;
        for(char ch : carr) {
            if(targetChar == ch) count++;
        }

        System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 " + targetChar + "은 " + count + "개 입니다.");
    }
}
