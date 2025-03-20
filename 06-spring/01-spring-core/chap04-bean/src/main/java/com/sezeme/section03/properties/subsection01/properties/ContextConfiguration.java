package com.sezeme.section03.properties.subsection01.properties;

import com.sezeme.common.Beverage;
import com.sezeme.common.Bread;
import com.sezeme.common.Product;
import com.sezeme.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {
    /* 치환자 문법(placeholder)를 이용하여 properties에 저장 된키 값을 입력하면
     * value에 해당하는 값이 가져와져서 주입 된다.
     * 양 옆에 공백이 있을 경우 값을 읽어오지 못하므로 주의!!
     * 뒤에 : 을 사용하여 key 값이 없을 경우에 대체값을 작성할 수 있다. */
    @Value("${bread.carpbread.name:그냥빵}")
    private String name;
    @Value("${bread.carpbread.price:0}")
    private int price;

    @Bean
    public Product carpBread() {
        return new Bread(name, price, new Date());
    }

    @Bean
    public Product milk(
            @Value("${beverage.milk.name}") String name,
            @Value("${beverage.milk.price}") int price,
            @Value("${beverage.milk.capacity}") int capacity
    ) {
        return new Beverage(name, price, capacity);
    }

    @Bean
    public Product water(
            @Value("${beverage.water.name}") String name,
            @Value("${beverage.water.price}") int price,
            @Value("${beverage.water.capacity}") int capacity
    ) {
        return new Beverage(name, price, capacity);
    }

    @Bean
    @Scope("prototype") //필요 시 마다 새로운 인스턴스를 생성해서 반환
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
