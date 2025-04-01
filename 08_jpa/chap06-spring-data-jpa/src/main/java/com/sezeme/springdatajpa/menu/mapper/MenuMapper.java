package com.sezeme.springdatajpa.menu.mapper;

import com.sezeme.springdatajpa.menu.dto.MenuDTO;
import com.sezeme.springdatajpa.menu.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    /* MapStruct 라이브러리 : 컴파일 타임에 매핑 코드를 생성해주는 라이브러리로, 어노테이션 기반으로 간결하게 작성할 수 있음
     *    - 컴파일 시점에 타입 검사가 이루어지므로 안정성이 높음, 런타임 오버헤드 없이 빠른 매핑이 가능
     *    - 초기 설정 및 어노테이션 사용법 숙지가 필요, 복잡한 커스텀 매핑 시 추가 설정이 요구됨
     * */
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    MenuDTO menuToMenuDTO(Menu menu);
    Menu menuDTOToMenu(MenuDTO menuDTO);
}
