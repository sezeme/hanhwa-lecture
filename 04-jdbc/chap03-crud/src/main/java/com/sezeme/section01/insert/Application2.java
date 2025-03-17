package com.sezeme.section01.insert;

import java.util.Scanner;

/* 콘솔을 통해 입출력하는 내용(View)*/
public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴 가격 : ");
        int menuPrice = sc.nextInt();
        System.out.print("카테고리 코드 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.print("판매상태 : ");
        String orderableStatus = sc.nextLine();

        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        MenuService menuService = new MenuService();
        menuService.registMenu(menu);
    }
}
