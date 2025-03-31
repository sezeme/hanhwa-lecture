package com.sezeme.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long countMenuOfCategory(int categoryCode) {
        String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";

        return entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
    }

    /* COUNT 외의 그룹 함수의 경우 결과 행이 없을 때 null 값이 반환 되므로
    * 기본 자료형으로 다룰 경우 문제가 생긴다. Long or Double 등의 Wrapper 타입으로 취급하도록 한다. */
    public Long sumMenuPriceOfCategory(int categoryCode) {
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";

        return entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
    }

    // 이렇게 가공된 결과값은 엔티티로 매핑 x
    public List<Object[]> selectByGroupByHaving(long minPrice) {
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice) FROM Section05Menu m "
                + "GROUP BY m.categoryCode HAVING SUM(m.menuPrice) >= :minPrice";
        return entityManager.createQuery(jpql).setParameter("minPrice", minPrice).getResultList();
    }
}
