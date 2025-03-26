package com.sezeme.springmybatis.section01.factorybean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/* 단위 테스트
* Mockito 를 활용하여 의존성을 모킹(Moking)한 후 MenuService의 순수 비즈니스 로직을 점증
 */
@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    // @Mock : 모의 객체로 생성
    @Mock
    private SqlSessionTemplate sqlSession; // 실제 DB 연결 없이 메소드 호출 처리 가능

    @Mock
    private MenuMapper menuMapper; // Mybatis Mapper 구현체 없이 메소드 호출 가능

    // @InjectMocks : 모의 객체를 MenuService에 주입하여 내부 의존성이 대체됨
    @InjectMocks
    private MenuService menuService;

    @BeforeEach
    public void setUp() {
        // sqlSession.getMapper(MenuMapper.class) 호출 시에 모의 객체 menuMapper를 반환하도록 설정
        when(sqlSession.getMapper(MenuMapper.class)).thenReturn(menuMapper);
    }

    /* 1. 주문 가능 상태 "Y"를 전달하는 테스트 시나리오 */
    @Test
    public void testFindAllMenuByOrderableStatus_Orderable() {
        //given
        String orderableStatus = "Y";
        MenuDTO menu1
                = new MenuDTO(1,"김치찌개", 8000, 1, "Y");
        MenuDTO menu2
                = new MenuDTO(2,"된장찌개", 8000, 1, "Y");
        List<MenuDTO> originalList = Arrays.asList(menu1, menu2);

        // 모의 객체 MenuMapper가 findAllMenuByOrderableStatus 기능 호출 시 originalList를 반환하도록 설정
        when(menuMapper.findAllMenuByOrderableStatus(orderableStatus)).thenReturn(originalList);

        // when
        List<MenuDTO> resultList = menuService.findAllMenuByOrderableStatus(orderableStatus);

        // then

        // 주어진 결과 값이 올바른 비즈니스 로직을 통해 가공 되었는지 확인
        assertNotNull(resultList);
        assertEquals(2, resultList.size());
        assertEquals("김치찌개 (주문 가능)", resultList.get(0).getMenuName());
        assertEquals("된장찌개 (주문 가능)", resultList.get(1).getMenuName());
        // 해당 객체에서 메소드 호출 여부 확인 -> 서비스 냅부의 상호 작용이 기대한 대로 이루어졌는지
        verify(sqlSession).getMapper(MenuMapper.class);
        verify(menuMapper).findAllMenuByOrderableStatus(orderableStatus);
    }


    /* 2. 주문 가능 상태 "N"를 전달하는 테스트 시나리오 */
    @Test
    public void testFindAllMenuByOrderableStatus_NotOrderable() {
        //given
        String orderableStatus = "N";
        MenuDTO menu1
                = new MenuDTO(1,"김치찌개", 8000, 1, "N");
        MenuDTO menu2
                = new MenuDTO(2,"된장찌개", 8000, 1, "N");
        List<MenuDTO> originalList = Arrays.asList(menu1, menu2);

        // 모의 객체 MenuMapper가 findAllMenuByOrderableStatus 기능 호출 시 originalList를 반환하도록 설정
        when(menuMapper.findAllMenuByOrderableStatus(orderableStatus)).thenReturn(originalList);

        // when
        List<MenuDTO> resultList = menuService.findAllMenuByOrderableStatus(orderableStatus);

        // then

        // 주어진 결과 값이 올바른 비즈니스 로직을 통해 가공 되었는지 확인
        assertNotNull(resultList);
        assertEquals(2, resultList.size());
        assertEquals("김치찌개 (주문 불가능)", resultList.get(0).getMenuName());
        assertEquals("된장찌개 (주문 불가능)", resultList.get(1).getMenuName());
        // 해당 객체에서 메소드 호출 여부 확인 -> 서비스 냅부의 상호 작용이 기대한 대로 이루어졌는지
        verify(sqlSession).getMapper(MenuMapper.class);
        verify(menuMapper).findAllMenuByOrderableStatus(orderableStatus);
    }

}