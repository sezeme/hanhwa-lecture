package com.sezeme.associationmapping.section03.bidirection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiDirectionServiceTest {
    @Autowired
    private BiDirectionService biDirectionService;

    @DisplayName("양방향 연관관계 매핑 조회 테스트1 (연관관계의 주인인 객체)")
    @Test
    void biDirectionFindTest1() {
        //given
        int menuCode = 10;

        //when
        /* 진짜 연관관계 : 처음 조회 시부터 조인한 결과를 인출해 온다. */
        Menu foundMenu = biDirectionService.findMenu(menuCode);

        //then
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("[ Menu ] " + foundMenu);
    }

    @DisplayName("양방향 연관관계 매핑 조회 테스트2 (연관관계의 주인이 아닌 객체)")
    @Test
    void biDirectionFindTest2() {
        //given
        int categoryCode = 10;

        //when
        /* 가짜 연관관계
         * 해당 엔티티를 조회하고 필요 시 연관관계 엔티티를 조회하는 쿼리를 실행한다.
         */
        Category foundCategory = biDirectionService.findCategory(categoryCode);

        //then
        Assertions.assertEquals(categoryCode,foundCategory.getCategoryCode());
        System.out.println("[ Category ] " + foundCategory.getMenuList());
    }

    private static Stream<Arguments> getMenuInfo() {
        return Stream.of(
                Arguments.of(111, "스테이크 크림 파스타", 9800, "Y")
        );
    }

    @DisplayName("양방향 연관관계 주인 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void biDirectionInsertTest1(
            int menuCode, String menuName, int menuPrice, String orderableStatus
    ) {
        //given
        Category category = biDirectionService.findCategory(4);
        Menu menu
                = new Menu(menuCode, menuName, menuPrice, category, orderableStatus);

        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> biDirectionService.registMenu(menu)
        );
    }

    private static Stream<Arguments> getCategoryInfo() {
        return Stream.of(
                Arguments.of(111, "양방향 카테고리", null)
        );
    }

    @DisplayName("양방향 연관관계 주인이 아닌 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getCategoryInfo")
    void biDirectionInsertTest2(
            int categoryCode, String categoryName, Integer refCategoryCode
    ) {
        //given
        Category category = new Category(
                categoryCode,
                categoryName,
                refCategoryCode
        );

        //when
        biDirectionService.registCategory(category);

        //then
        Category foundCategory = biDirectionService.findCategory(categoryCode);
        Assertions.assertNotNull(foundCategory);
    }
}