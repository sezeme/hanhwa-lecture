package com.sezeme.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {
    // 스프링 환경에서 해당 객체를 주입 받아서 사용.
    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery() {
        // 별칭 필수
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    public Menu selectSingleRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu resultMenu = query.getSingleResult();
        return resultMenu;
    }

    public List<Menu> selectMultiRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu as m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultMenu = query.getResultList();
        return resultMenu;
    }

    /* tbl_menu 의 categoryCode 중복 없이 조회 */
    public List<Integer> selecUsingDistinct() {
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu as m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultMenu = query.getResultList();
        return resultMenu;
    }

    /* tbl_menu 의  11, 12 categoryCode 가진 메뉴 목록 조회 */
    public List<Menu> selecUsingIn() {
        String jpql = "SELECT m FROM Section01Menu as m WHERE categoryCode IN (11, 12)";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultMenu = query.getResultList();
        return resultMenu;
    }

    /* tbl_menu 의  "마늘" 이 메뉴명에 포함 된 메뉴 목록 조회 */
    public List<Menu> selecUsingLike() {
        String jpql = "SELECT m FROM Section01Menu as m WHERE menuName LIKE '%마늘%'";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultMenu = query.getResultList();
        return resultMenu;
    }
}
