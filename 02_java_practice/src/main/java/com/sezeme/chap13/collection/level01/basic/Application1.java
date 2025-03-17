package com.sezeme.chap13.collection.level01.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score;
        char answer = 'y';
        ArrayList<Integer> list = new ArrayList<>();

        while (answer == 'y' || answer == 'Y') {
            System.out.print("학생 성적 : ");
            score = sc.nextInt();

            list.add(score);

            System.out.print("추가 입력하려면 y : ");
            answer = sc.next().charAt(0);
        }

        double avg = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            avg += it.next();
        }
        avg /= list.size();
        System.out.println("학생 인원 : " + list.size());
        System.out.println("평균 점수 : " + avg);
    }
}
