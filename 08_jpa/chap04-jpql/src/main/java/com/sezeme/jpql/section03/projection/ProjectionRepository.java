package com.sezeme.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

// find가 아니라 jpql로 찾아온 애도 영속성 컨텍스트에서 관리가 되고 있는지
// select절에 entity를 써야만 영속성 컨텍스트로 관리가 된다.
    public List<Menu> singleEntityProjection() {
        String jpql = "SELECT m FROM Section03Menu m";
        List<Menu> menuList
                = entityManager.createQuery(jpql, Menu.class).getResultList();

        return menuList;
    }

    public List<MenuInfo> embeddedTypeProjection() {
        String jpql = "SELECT m.menuInfo FROM EmbeddedMenu m"; // from 절은 무조건 엔티티만 들어갈 수 있음
        return entityManager.createQuery(jpql, MenuInfo.class).getResultList();
    }

    public List<Object[]> scalarTypeProjection() {
        String jpql = "SELECT c.categoryCode, c.categoryName  FROM Section03Category c"; // from 절은 무조건 엔티티만 들어갈 수 있음
            return entityManager.createQuery(jpql).getResultList();
            // TypedQuery 타입이 아닌, Query 타입으로 반환.
    }

    public List<CategoryInfo> newCommandProjection() {
        String jpql = "SELECT new com.sezeme.jpql.section03.projection.CategoryInfo(" +
                "c.categoryCode, c.categoryName) FROM Section03Category c";
        return entityManager.createQuery(jpql, CategoryInfo.class).getResultList();
    }
}
