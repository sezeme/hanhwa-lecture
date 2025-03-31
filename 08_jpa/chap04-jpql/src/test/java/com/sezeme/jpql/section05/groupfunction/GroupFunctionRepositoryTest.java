package com.sezeme.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupFunctionRepositoryTest {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리에 해당하는 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory() {
        int categoryCode = 777;
        long menuCount = groupFunctionRepository.countMenuOfCategory(categoryCode);
        assertTrue(menuCount >= 0);
    }

    @DisplayName("특정 카테고리에 해당하는 메뉴 가격의 합 조회")
    @Test
    void testSumMenuPriceOfCategory() {
        int categoryCode = 777;
        assertDoesNotThrow(
                () -> {
                    Long sumMenuPrice = groupFunctionRepository.sumMenuPriceOfCategory(categoryCode);
                    System.out.println("sumMenuPrice=" + sumMenuPrice);
                }
        );
    }

    @DisplayName("Group By, Having 절 테스트")
    @Test
    void selectByGroupByHaving() {
        long minPrice = 50000L;
        List<Object[]> sumPriceCategoryList = groupFunctionRepository.selectByGroupByHaving(minPrice);
        assertNotNull(sumPriceCategoryList);
        sumPriceCategoryList.forEach(
                row -> {
                    for(Object column : row) System.out.print(column + " ");
                    System.out.println();
                }
        );
    }
}