package com.sezeme.section03.delete;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("없앨 메뉴의 코드 : ");
        int menuCode = sc.nextInt();

        Menu menu = new Menu(menuCode);

        MenuService menuService = new MenuService();
        menuService.removeMenu(menu);
    }
}
