package com.sezeme.chap05.array.level02.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호를 입력하세요 : ");
        String residentRegistrationNumber = sc.nextLine();

        char[] carr = residentRegistrationNumber.toCharArray();

        for(int i = 8; i<carr.length; i++){
            carr[i] = '*';
        }

        for(char ch : carr) {
            System.out.print(ch);
        }
    }
}
