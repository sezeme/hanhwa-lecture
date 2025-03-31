package com.sezeme.jpql.section03.projection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectionSeviceTest {

    @Autowired
    private ProjectionSevice projectionService;

    @DisplayName("엔터티 프로젝션 테스트")
    @Test
    public void testSingleEntityProjection() {
        List<Menu> menus = projectionService.singleEntityProjection();
        assertNotNull(menus);
    }
}