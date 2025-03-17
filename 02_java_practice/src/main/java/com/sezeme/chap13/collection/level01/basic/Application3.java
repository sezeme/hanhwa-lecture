package com.sezeme.chap13.collection.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        Queue<String> q = new LinkedList<>();

        while (true) {
            System.out.print("대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ");
            name = sc.nextLine();

            if(name.equals("exit")) break;
            else if(name.equals("next")) {
                if(q.isEmpty()) {
                    System.out.println("대기 고객이 없습니다.");
                    continue;
                }
                name = q.poll();
                System.out.println(name + " 고객님 차례입니다.");
            } else {
                q.add(name);
                System.out.println(name + " 고객님 대기 등록되었습니다.");
            }
        }
    }
}
