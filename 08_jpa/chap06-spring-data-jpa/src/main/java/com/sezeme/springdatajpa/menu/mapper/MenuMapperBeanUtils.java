package com.sezeme.springdatajpa.menu.mapper;

import com.sezeme.springdatajpa.menu.dto.MenuDTO;
import com.sezeme.springdatajpa.menu.entity.Menu;

/* Spring BeanUtils.copyProperties() : Spring Framework에서 제공하는 BeanUtils를 활용하여 동일한 이름과 타입의 프로퍼티를 자동으로 복사
 *    - 간단한 코드로 기본적인 매핑을 빠르게 처리할 수 있음
 *    - 깊은 복사(deep copy)나 커스텀 변환이 어려움, 필드명이 다르거나 복잡한 변환 규칙이 필요한 경우에는 한계가 있음
 * */
public class MenuMapperBeanUtils {
    public static MenuDTO toDTO(Menu menu) {
        MenuDTO dto = new MenuDTO();
        org.springframework.beans.BeanUtils.copyProperties(menu, dto);
        return dto;
    }

    public static Menu toEntity(MenuDTO dto) {
        Menu menu = new Menu();
        org.springframework.beans.BeanUtils.copyProperties(dto, menu);
        return menu;
    }
}
