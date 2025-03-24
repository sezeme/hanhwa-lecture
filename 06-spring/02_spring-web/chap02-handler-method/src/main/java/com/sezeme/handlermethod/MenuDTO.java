package com.sezeme.handlermethod;

/* 커멘드 객체로 사용하기 위해서는 name 속성 값과 필드명이 일치하도록 작성해야 한다. */
public class MenuDTO {
    String name;
    int price;
    int categoryCode;

    public MenuDTO(String name, int price, int categoryCode) {
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
    }
}
