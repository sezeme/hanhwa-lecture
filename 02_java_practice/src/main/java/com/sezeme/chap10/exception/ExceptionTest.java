package com.sezeme.chap10.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    public static void checkAdult(String birthday) throws InvalideAgeException {
        LocalDate adultDate = LocalDate.parse(birthday).plusYears(20);
        LocalDate localDate = LocalDate.now();

        if(localDate.isBefore(adultDate)) {
            throw new InvalideAgeException("만 20세 미만은 입장 불가입니다.");
        }
    }

    public static void checkInput(String birthday) throws IllegalArgumentException {
        String[] str = birthday.split("-");
        for(String s : str) {
            Integer.parseInt(s);
        }
    }
}
