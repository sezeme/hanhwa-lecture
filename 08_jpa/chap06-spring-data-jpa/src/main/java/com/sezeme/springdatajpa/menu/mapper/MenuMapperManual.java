package com.sezeme.springdatajpa.menu.mapper;

import com.sezeme.springdatajpa.menu.dto.MenuDTO;
import com.sezeme.springdatajpa.menu.entity.Menu;

/* 수동 매핑 메서드 : toEntity, toDTO 등 메서드를 직접 구현하여 각 객체 간의 변환 로직을 명시적으로 관리
 * - 변환 로직이 명시적이어서 추적과 디버깅이 용이, 복잡한 변환 로직이나 조건부 매핑 등 세밀한 제어가 가능
 * - 객체가 많거나 필드가 많아질 경우 중복 코드가 늘어나고 유지보수가 어려워질 수 있음
* */
public class MenuMapperManual {

    // entity -> dto 직접 매핑
    public static MenuDTO toDTO(Menu menu) {
        MenuDTO dto = new MenuDTO();
        dto.setMenuCode(menu.getMenuCode());
        dto.setMenuName(menu.getMenuName());
        dto.setMenuPrice(menu.getMenuPrice());
        dto.setCategoryCode(menu.getCategoryCode());
        dto.setOrderableStatus(menu.getOrderableStatus());
        return dto;
    }

    // dto -> entity 직접 매핑
    public static Menu toEntity(MenuDTO dto) {

        // 생성자 패턴
//        return new Menu(dto.getMenuCode(), dto.getMenuName(), dto.getMenuPrice(), dto.getCategoryCode(), dto.getOrderableStatus());

        // 빌더 패턴
        return Menu.builder()
                .menuCode(dto.getMenuCode())
                .menuName(dto.getMenuName())
                .menuPrice(dto.getMenuPrice())
                .categoryCode(dto.getCategoryCode())
                .orderableStatus(dto.getOrderableStatus())
                .build();

    }
}
