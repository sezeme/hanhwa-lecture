package com.sezeme.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectByInnerJoin() {
        // 지연 로딩
        // N+1의 문제가 발생 : 어떠한 구문으로서 실제 실행되고 있는지를 체크해야 함
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    public List<Menu> selectByFetchJoin() {
        // fetch : JPQL에서 성능 최적화를 위해 사용 하는 기능으로
        // 연관 엔터티나 컬렉션을 한 번에 조회한다.
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    public List<Object[]> selectByOuterJoin() {
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m " +
                "RIGHT JOIN m.category c";

        return entityManager.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByCollectionJoin() {
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Category c " +
                "RIGHT JOIN c.menuList m";

        return entityManager.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByThetaJoin() {
        // 카티전 프로적트
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Category c, " +
                "Section06Menu m";

        return entityManager.createQuery(jpql).getResultList();
    }

}
