package com.sezeme.associationmapping.section03.bidirection;

import jakarta.persistence.*;

@Entity(name="bidirection_menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;

    private String menuName;

    private int menuPrice;

    @JoinColumn(name="categoryCode")
    @ManyToOne // 진짜 fk
    private Category category;

    private String orderableStatus;

    protected Menu() {}

    public Menu(
            int menuCode, String menuName, int menuPrice, String orderableStatus
    ) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.orderableStatus = orderableStatus;
    }

    public Menu(
            int menuCode, String menuName, int menuPrice,
            Category category, String orderableStatus
    ) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }
    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public int getMenuPrice() {
        return menuPrice;
    }
    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }
    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }
    @Override
    public String toString() {
        return "Menu [menuCode=" + menuCode +
                ", menuName=" + menuName +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + category.getCategoryCode() +
                ", orderableStatus=" + orderableStatus + "]";
    }
}