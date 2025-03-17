package com.sezeme.chap10.exception;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
        String birthday = sc.nextLine();

        try {
            ExceptionTest.checkInput(birthday);

            ExceptionTest.checkAdult(birthday);
            System.out.println("입장하셔도 됩니다.");
        } catch (InvalideAgeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("날짜 양식을 잘못 입력하셨습니다.");
        }
    }
}
