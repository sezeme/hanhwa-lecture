package com.sezeme.chap04.conditional.level03.hard;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        final int APPLE_PRICE = 1000;
        final int BANANA_PRICE = 3000;
        final int PEACH_PRICE = 2000;
        final int KIWI_PRICE = 5000;

        System.out.println("--상품가격--\n" +
                "사과 : 1000원\n" +
                "바나나 : 3000원\n" +
                "복숭아 : 2000원\n" +
                "키위 : 5000원");
        System.out.print("\n\n과일 이름을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int productPrice = switch (str) {
            case "사과" -> APPLE_PRICE;
            case "바나나" -> BANANA_PRICE;
            case "복숭아" -> PEACH_PRICE;
            case "키위" -> KIWI_PRICE;
            default -> 0;
        };

        if(productPrice == 0) System.out.println("준비된 상품이 없습니다.");
        else {
            System.out.println(str + "의 가격은 " + productPrice + "원 입니다.");
        }
    }
}
