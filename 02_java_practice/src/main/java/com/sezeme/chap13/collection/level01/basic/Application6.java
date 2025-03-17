package com.sezeme.chap13.collection.level01.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Application6 {
    static HashMap<String, String> phoneDict = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringTokenizer st;
        String input;

        while (true) {
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ");
            input = sc.nextLine();

            if(input.equals("exit")) break;
            else if(input.equals("search")) searchPhonenum();
            else {
                st = new StringTokenizer(input);
                if(st.countTokens() != 2) {
                    System.out.println("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
                    continue;
                }
                phoneDict.put(st.nextToken(), st.nextToken());
                System.out.println("추가 완료 : " + input);
            }
        }
    }

    private static void searchPhonenum() {
        System.out.print("검색 할 이름 : ");
        String name = sc.nextLine();
        String phonenum;
        if((phonenum = phoneDict.get(name)) == null)
            System.out.println(name + "씨의 전화번호는 등록 되어 있지 않습니다.");
        else
            System.out.println(name + "씨의 전화번호 : " + phonenum);
    }
}
