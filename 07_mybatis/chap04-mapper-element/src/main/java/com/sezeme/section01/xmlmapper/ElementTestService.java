package com.sezeme.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sezeme.common.Template.getSqlSession;

public class ElementTestService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> menuList = mapper.selectResultMapCollectionTest();

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }
}
