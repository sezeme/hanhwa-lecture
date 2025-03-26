package com.sezeme.section01.xmlmapper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("===== Mapper Element 테스트 (ResultMap 테스트) =====");
            System.out.println("1. <resultMap> 테스트 ");
            System.out.println("2. <association> 테스트 ");
            System.out.println("3. <collection> 테스트 ");
            System.out.print("메뉴 번호 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : elementTestService.selectResultMapTest(); break;
                case 2 : elementTestService.selectResultMapAssociationTest(); break;
                case 3 : elementTestService.selectResultMapCollectionTest(); break;
                default:
                    System.out.println("잘못 된 번호를 입력하셨습니다.");
            }
        } while(true);
    }
}
