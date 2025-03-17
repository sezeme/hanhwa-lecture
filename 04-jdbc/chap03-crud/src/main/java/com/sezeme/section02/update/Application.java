package com.sezeme.section02.update;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("바꿀 메뉴의 코드 : ");
        int menuCode = sc.nextInt();
        sc.nextLine();
        System.out.print("새로 바꿀 메뉴 이름 : ");
        String menuName = sc.nextLine();
        System.out.print("새로 바꿀 메뉴 가격 : ");
        int menuPrice = sc.nextInt();

        Menu menu = new Menu(menuName, menuPrice);

        menu.setMenuCode(menuCode);
        MenuService menuService = new MenuService();
        menuService.editMenu(menu);
    }
}
