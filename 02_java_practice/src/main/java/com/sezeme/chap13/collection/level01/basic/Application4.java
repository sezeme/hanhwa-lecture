package com.sezeme.chap13.collection.level01.basic;

import java.util.*;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id;
        HashSet<String> students = new HashSet<>();

        while (true) {
            System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
            id = sc.nextLine();

            if(id.equals("exit")) break;

            students.add(id);
            System.out.println("ID가 추가 되었습니다.");
        }

        System.out.println("모든 학생의 ID : " + students);

    }
}
