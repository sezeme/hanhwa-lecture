package com.sezeme.associationmapping.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "category_and_menu")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;

    private String categoryName;

    private Integer refCategoryCode;

    /* fetch type default 는 LAZY 로 필요한 시점에 별도로 로딩해 온다. (select 문이 별도로 동작)
    * 즉시 로딩이 필요한 경우에는 fetch type을 EAGER 로 명시해주어야 join 되어 한 번에 조회 된다. */
    @JoinColumn(name="categoryCode")
    @OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Menu> menuList;

    protected Category() {}

    public Category(
            int categoryCode, String categoryName,
            Integer refCategoryCode, List<Menu> menuList
    ) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }
    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }
    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }
    public List<Menu> getMenuList() {
        return menuList;
    }
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
    @Override
    public String toString() {
        return "CategoryAndMenu [categoryCode=" + categoryCode +
                ", categoryName=" + categoryName +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList + "]";
    }
}