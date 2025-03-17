package com.sezeme.chap04.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열을 입력하세요 : ");
        String[] list = sc.nextLine().split(" ");
        System.out.print("숫자를 입력하세요 : ");
        int jumpSize = sc.nextInt();

        for (String s : list) {
            char ch = s.charAt(0);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char)(((ch - 'a') + jumpSize) % 26 + 'a'));
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(((ch - 'A') + jumpSize) % 26 + 'A'));
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
