package com.sezeme.chap06.class_and_object.level01.basic.student.run;

import com.sezeme.chap06.class_and_object.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] studentDTOs = new StudentDTO[10];
        int count = 0;
        String answer = "y";
        while((answer.equals("y") || answer.equals("Y")) && count < 10) {
            System.out.print("학년 : ");
            int grade = sc.nextInt();
            System.out.print("반 : ");
            int classroom = sc.nextInt();
            sc.nextLine();
            System.out.print("이름 : ");
            String name = sc.nextLine();
            System.out.print("국어점수 : ");
            int kor = sc.nextInt();
            System.out.print("영어점수 : ");
            int eng = sc.nextInt();
            System.out.print("수학점수 : ");
            int math = sc.nextInt();
            sc.nextLine();

            studentDTOs[count++] = new StudentDTO(grade,classroom,name,kor,eng,math);
            System.out.print("계속 추가할 겁니까 ? (y/n) : ");
            answer = sc.nextLine();
        }

        for(int i = 0; i<count; i++) {
            studentDTOs[i].getInformation();
        }
    }
}
