package com.sezeme.section01.xml;

import com.sezeme.common.MenuDTO;
import com.sezeme.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.sezeme.common.Template.getSqlSession;

public class MenuService {
    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* 기본 자료형의 변수명으로는 if문의 조건에서 값을 비교할 수 없다.
        * Map에 기본 자료형 값을 담아 전달하도록 한다.
        * (Map의 key 값, DTO 객체의 필드 값) */
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);
        List<MenuDTO> menuList = dynamicSqlMapper.selectMenuByPrice(map);

        if(menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenu(searchCriteria);

        if(menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();

    }

    public void searchMenuByRandomMenuCode(Set<Integer> randomMenuCodeList) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Set<Integer>> criteria = new HashMap<>();
        criteria.put("randomMenuCodeList", randomMenuCodeList);
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByRandomMenuCode(criteria);

        if(menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();

    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {

    }
}
