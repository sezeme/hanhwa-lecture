package com.sezeme.chap06.class_and_object.level02.normal.book.run;

import com.sezeme.chap06.class_and_object.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO[] bookDTOs = new BookDTO[3];

        bookDTOs[0] = new BookDTO();
        bookDTOs[1] = new BookDTO("자바의 정석", "도우출판", "남궁성");
        bookDTOs[2] = new BookDTO("홍길동전", "활빈당", "허균", 5000000, 0.5);

        for(BookDTO bookDTO : bookDTOs) {
            bookDTO.printInformation();
        }
    }
}
