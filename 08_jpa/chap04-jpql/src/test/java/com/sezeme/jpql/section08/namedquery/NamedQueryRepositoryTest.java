package com.sezeme.jpql.section08.namedquery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NamedQueryRepositoryTest {

    @Autowired
    private NamedQueryRepository namedQueryRepository;


    @DisplayName("동적쿼리를 이용한 조회 테스트")
    @Test
    public void testSelectByDynamicQuery() {
        //given
        String searchName = "열무김치라떼";
        int searchCode = 8;

        //when
        List<Menu> menuList
                = namedQueryRepository.selectByDynamicQuery(searchName, searchCode);

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("namedQuery를 이용한 조회 테스트")
    @Test
    public void testSelectByNamedQuery() {

        //when
        List<Menu> menuList
                = namedQueryRepository.selectByNamedQuery();

        //then
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("xml 기반 NamedQuery를 이용한 조회 테스트")
    @Test
    public void testSelectByNamedQueryWithXml() {
        //given
        int menuCode = 20;

        //when
        Menu foundMenu = namedQueryRepository.selectByNamedQueryWithXml(menuCode);

        //then
        Assertions.assertNotNull(foundMenu);
        System.out.println(foundMenu);
    }
}