package com.sezeme.chap09.api;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("문자열 입력 : ");
        String[] strings = sc.nextLine().split(" ");

        // 앞뒤 공백 제거 및 연속된 공백을 하나의 구분자로 처리
//        String[] words = input.trim().split("\\s+");

        for(String string : strings) {
            char[] chars = string.toCharArray();
            if(chars[0] >= 'a' && chars[0] <= 'z'){
                chars[0] -= 32;
            }
            sb.append(chars).append(" ");
        }

        System.out.println("변환된 문자열: " + sb);
        System.out.println("총 단어 개수: " + strings.length);
    }

    private static String capitalizeWord(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
