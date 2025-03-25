package com.sezeme.section03.remix;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {
        System.out.println("===== 메뉴 목록 ======");
        for(MenuDTO menuDTO : menuList) {
            System.out.println(menuDTO);
        }
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("===== 조회 된 메뉴 =====");
        System.out.println(menu);
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("===== Error =====");
        String errorMessage = switch (errorCode) {
            case "selectList" -> "메뉴 목록 조회에 실패했습니다.";
            case "selectOne" -> "메뉴 코드로 메뉴 조회에 실패했습니다.";
            case "insert" -> "신규 메뉴 등록에 실패했습니다.";
            case "update" -> "메뉴 수정에 실패했습니다.";
            case "delete" -> "메뉴 삭제에 실패했습니다.";
            default -> "";
        };

        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("===== Success =====");
        String successMessage = switch (successCode) {
            case "insert" -> "신규 메뉴 등록이 완료 되었습니다.";
            case "update" -> "메뉴 수정이 완료 되었습니다.";
            case "delete" -> "메뉴 삭제가 완료 되었습니다.";
            default -> "";
        };
        System.out.println(successMessage);
    }

}
