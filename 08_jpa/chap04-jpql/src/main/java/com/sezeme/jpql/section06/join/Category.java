package com.sezeme.jpql.section06.join;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="Section06Category")
@Table(name="tbl_category")
public class Category {
    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;
}
