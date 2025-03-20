package com.sezeme.section01.scope.subsection01.singleton;

import com.sezeme.common.Beverage;
import com.sezeme.common.Bread;
import com.sezeme.common.Product;
import com.sezeme.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/* @Configuration 넣지 않아도 설정 등록ㅇ ㅣ일어날 것이다???*/
public class ContextConfiguration {
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }
    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }
    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }
    @Bean
    @Scope("singleton") //기본값
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
