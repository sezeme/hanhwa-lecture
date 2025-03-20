package com.sezeme.section03.properties.subsection01.properties;

import com.sezeme.common.Product;
import com.sezeme.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* IoC container 생성 */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                ContextConfiguration.class
        );

        /* 슈퍼에 상품이 진열되어 있다. */
        Product carpBread = applicationContext.getBean("carpBread", Product.class);
        Product milk = applicationContext.getBean("milk", Product.class);
        Product water = applicationContext.getBean("water", Product.class);

        /* 쇼핑 카트를 꺼내 상품을 담는다. */
        ShoppingCart shoppingCart = applicationContext.getBean("cart", ShoppingCart.class);
        shoppingCart.addItem(carpBread);
        shoppingCart.addItem(milk);
        System.out.println("cart에 담긴 물품 : " + shoppingCart.getItem());

        /* 다음 손님이 와서 쇼핑 카트를 사용한다. */
        ShoppingCart shoppingCart2 = applicationContext.getBean("cart", ShoppingCart.class);
        shoppingCart2.addItem(water);
        System.out.println("cart에 담긴 물품 : " + shoppingCart2.getItem());

        /* Spring 컨테이너 종료 전에 메인 스레드의 동작이 종료 되고 프로세스가 종료 되어
        * destroy method가  확인 되지 않으므로 명시적으로 컨테이너를 종료 시켜서 확인한다. */
        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
