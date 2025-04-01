package com.sezeme.nativequery.section02.namedquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NamedNativeQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> selectByNamedNativeQuery() {
        Query nativeQuery
                = entityManager.createNamedQuery("Category.menuCountOfCategory");
        return nativeQuery.getResultList();
    }
}
