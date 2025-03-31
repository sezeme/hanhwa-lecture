package com.sezeme.jpql.section08.namedquery;

import jakarta.persistence.*;

@Entity(name = "Section08Menu")
@Table(name = "tbl_menu")
@NamedQueries({
        @NamedQuery(name = "Section08Menu.selectMenuList",
        query = "SELECT m FROM Section08Menu m")
})
public class Menu {
    // @id 필수 : 영속성 컨텍스트에서 구분 기준이 됨.
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public Menu() {
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

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }
}