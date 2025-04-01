package com.sezeme.nativequery.section02.namedquery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NamedNativeQueryRepositoryTest {

    @Autowired
    private NamedNativeQueryRepository namedNativeQueryRepository;

    @DisplayName("NamedNativeQuery를 이용한 조회 테스트")
    @Test
    public void testSelectByNamedNativeQuery() {
        //given
        //when
        List<Object[]> categoryList;
        categoryList = namedNativeQueryRepository.selectByNamedNativeQuery();

        //then
        assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for(Object col : row) {
                        System.out.print(col + "/");
                    }
                    System.out.println();
                }
        );
    }
}