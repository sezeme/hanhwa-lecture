package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerGenerator {

    public static EntityManager getInstance() {
        EntityManagerFactory factory
                = EntityManagerFactoryGenerator.getInstance();
        return factory.createEntityManager();
    }

}
