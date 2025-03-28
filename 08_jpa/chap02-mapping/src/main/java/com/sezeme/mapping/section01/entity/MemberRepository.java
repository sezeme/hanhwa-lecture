package com.sezeme.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/* 빈 등록 함 */
@Repository
public class MemberRepository {
    /* 스프링 환경에서 알아서 필드 주입 시켜줌 */
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    public String findNameById(String memberId) {
        // JPQL 활용 (테이블명 -> 엔티티명, 컬럼명 -> 필드명)
        // 엔티티는 반드시 별칭을 사용해야 한다.
        String jpql = "SELECT m.memberName FROM entityMember m "
                + "WHERE m.memberId='" + memberId + "'";
        return entityManager.createQuery(jpql, String.class).getSingleResult();
    }
}
