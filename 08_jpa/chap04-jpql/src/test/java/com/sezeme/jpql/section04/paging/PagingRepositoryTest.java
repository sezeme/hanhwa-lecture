package com.sezeme.jpql.section04.paging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PagingRepositoryTest {

    @Autowired
    private PagingRepository pagingRepository;

    @DisplayName("페이징 api 를 이용한 조회 테스트")
    @Test
    void usingPagingAPI() {
        int offset = 0;
        int limit = 5;

        List<Menu> menuList = pagingRepository.usingPagingAPI(offset * limit, limit);
        assertNotNull(menuList);
        assertTrue(menuList.size() <= limit);
        menuList.forEach(System.out::println);
    }
}