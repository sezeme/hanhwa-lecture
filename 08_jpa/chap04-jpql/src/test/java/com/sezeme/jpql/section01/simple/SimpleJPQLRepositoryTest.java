package com.sezeme.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleJPQLRepositoryTest {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일행, 단일 컬럼 조회")
    @Test
    void testSelectSingleMenuByTypedQuery() {
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();
        assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("TypedQuery를 이용한 단일행 조회")
    @Test
    void testSelectSingleRowByTypedQuery() {
        Menu menu = simpleJPQLRepository.selectSingleRowByTypedQuery();
        assertNotNull(menu);
        assertEquals("한우딸기국밥", menu.getMenuName());
    }

    @DisplayName("TypedQuery를 이용한 다중행 조회")
    @Test
    void testSelectMultiRowByTypedQuery() {
        List<Menu> menuList = simpleJPQLRepository.selectMultiRowByTypedQuery();
        assertNotNull(menuList);
    }

    @Test
    void testSelectUsingDistinct() {
        List<Integer> categoryCodeList = simpleJPQLRepository.selecUsingDistinct();
        System.out.println("categoryCodeList\n" + categoryCodeList);

        assertNotNull(categoryCodeList);
        assertEquals(new HashSet<>(categoryCodeList).size(), categoryCodeList.size());
    }

    @Test
    void testSelectUsingIn() {
        List<Menu> menuList = simpleJPQLRepository.selecUsingIn();
        System.out.println("menuList\n" + menuList);

        assertNotNull(menuList);
    }

    @Test
    void testSelectUsingLike() {
        List<Menu> menuList = simpleJPQLRepository.selecUsingIn();
        System.out.println("menuList\n" + menuList);
        assertNotNull(menuList);
    }
}