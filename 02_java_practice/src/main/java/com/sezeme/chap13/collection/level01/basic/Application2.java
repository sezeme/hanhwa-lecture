package com.sezeme.chap13.collection.level01.basic;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Queue<String> q = new LinkedList<>();

        while (true) {
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            input = sc.nextLine();

            if(input.equals("exit")) break;

            q.add(input);

            if(q.size() > 5) q.poll();

            System.out.println("최근 방문 url : " + q);


        }
    }
}
