package com.sezeme.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Like like) {
        entityManager.persist(like);
    }
}
