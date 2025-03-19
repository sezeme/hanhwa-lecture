package com.sezeme.section01.autowired.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookDTO {
    private int sequence; //도서번호
    private int isbn; //isbn
    private String title; //제목
    private String author; //저자
    private String publisher; //출판사
    private Date createdDate; //출판일
}
