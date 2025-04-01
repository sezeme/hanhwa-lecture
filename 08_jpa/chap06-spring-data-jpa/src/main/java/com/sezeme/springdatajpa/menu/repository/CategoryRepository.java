package com.sezeme.springdatajpa.menu.repository;

import com.sezeme.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /* JPQL or Native Query 를 작성하는 방법 */
    @Query(
//            value = "SELECT c FROM Category c ORDER BY c.categoryCode"
            value = "SELECT category_code, category_name, ref_category_code " +
                    "FROM tbl_category ORDER BY category_code",
            nativeQuery = true // JPQL 일 경우 생략 (default false)
    )
    List<Category> findAllCategory();
    // Java 객체를 썼지만 조회가 잘 일어났다.
}
