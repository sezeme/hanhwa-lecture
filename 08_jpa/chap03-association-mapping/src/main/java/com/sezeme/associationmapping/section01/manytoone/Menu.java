package com.sezeme.associationmapping.section01.manytoone;

import jakarta.persistence.*;

@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;

    private String menuName;

    private int menuPrice;

    /* 영속성 전이 : 특정 엔터티를 영속화(영속성 컨텍스트에서 관리) 할 때 연관 된 엔터티도
    * 함께 영속화 한다는 의미이다
    * fetch type default 는 EAGER 로 되어 있으며 필요할 경우 LAZY로 명시해서 지연 로딩을 할 수 있다.
    * */
    @ManyToOne(cascade = CascadeType.PERSIST)
    // 다른 엔티티에 의존중, 안적으면 어떤 다중성을 가지고 있는지 표시해야함.
    @JoinColumn(name = "categoryCode")
    //"FK" 에 해당하는 컬럼명 ( 자동매핑이라 camelcase )
    private Category category;

    private String orderableStatus;

    protected Menu() {}

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

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}