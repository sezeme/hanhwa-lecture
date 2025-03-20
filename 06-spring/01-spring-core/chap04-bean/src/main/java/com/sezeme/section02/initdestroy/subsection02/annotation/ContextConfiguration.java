package com.sezeme.section02.initdestroy.subsection02.annotation;

import com.sezeme.common.Beverage;
import com.sezeme.common.Bread;
import com.sezeme.common.Product;
import com.sezeme.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
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
    @Scope("prototype") //필요 시 마다 새로운 인스턴스를 생성해서 반환
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

}
