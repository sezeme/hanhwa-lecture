package com.sezeme.chap04.looping_and_branching.level03.hard;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        try {
            for(int i = 0; i<str.length(); i++) {
                char ch2 = str.charAt(i);
                if ((ch2 < 'a' || ch2 > 'z') && (ch2 < 'A' || ch2 > 'Z'))
                    throw new IllegalArgumentException("영문자가 아닌 문자가 포함되어 있습니다.");
            }

            System.out.print("문자 입력 : ");
            char ch = sc.next().charAt(0);

            int count = 0;
            for(int i = 0; i < str.length() ; i++) if(ch == str.charAt(i)) count++;
            System.out.println("포함된 갯수 : " + count + "개");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
