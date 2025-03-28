package com.sezeme.associationmapping.section03.bidirection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "bidirection_category")
@Table(name = "tbl_category")
class Category {

    @Id
    private int categoryCode;

    private String categoryName;

    private Integer refCategoryCode;

    /* 양방향 연관관계를 맺을 경우 FK를 가진 엔터티를 진짜 연관관계라고 하며
    * FK를 가지지 않은 엔터티를 가짜 연관관계라고 한다.
    * 진짜 연관관게는 동일하게 매핑하면 되고 가짜 연관관게는 mappedBy 속성에
    * 진짜 연관관계의 필드명을 작성하여 매핑한다. */
    @OneToMany(mappedBy="category")
    private List<Menu> menuList;

    protected Category() {}

    public Category(
            int categoryCode, String categoryName, Integer refCategoryCode
    ) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

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
        return "Category [categoryCode=" + categoryCode +
                ", categoryName=" + categoryName +
                ", refCategoryCode=" + refCategoryCode + "]";
    }

}