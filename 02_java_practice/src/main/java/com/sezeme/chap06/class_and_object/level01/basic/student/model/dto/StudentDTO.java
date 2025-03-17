package com.sezeme.chap06.class_and_object.level01.basic.student.model.dto;

public class StudentDTO {
    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO() {
    }

    public StudentDTO(int grade, int classroom, String name, int kor, int eng, int math) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void getInformation() {
        int avg = (kor + eng + math)/3;
        System.out.println("학년=" + grade + ", 반=" + classroom + ", 이름=" + name + ", 국어=" + kor + ", 영어" + eng + ", 수학=" + math + ", 평균="+avg);
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getClassroom() {
        return this.classroom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getKor() {
        return kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getEng() {
        return eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getMath() {
        return math;
    }
}
