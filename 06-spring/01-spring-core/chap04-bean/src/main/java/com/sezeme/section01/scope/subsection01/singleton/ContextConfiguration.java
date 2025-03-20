package com.sezeme.section01.scope.subsection01.singleton;

import com.sezeme.common.Beverage;
import com.sezeme.common.Bread;
import com.sezeme.common.Product;
import com.sezeme.common.ShoppingCart;
import org.springframework.context.annotation.*;

/* @Configuration 넣지 않아도 설정 등록ㅇ ㅣ일어날 것이다???*/
public class ContextConfiguration {
    @Bean
    public Product carpBread() {
        System.out.println("빵 생성 시점");
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    @DependsOn({"carpBread", "milk", "water"}) // 나열한 빈 인스턴스가 모두 생성 된 뒤 생성되도록
    // 원래는 코드 순서대로 생성이 된다. 그러나 빈 생성 시 사전에 생성되어야 하는 빈이 있다면 생성 순서를 지정
    @Lazy // 컨테이너 동작 시점이 아니라 해당 객체 필요 시점에 인스턴스를 생성한다.
    @Scope("singleton") //기본값
    public ShoppingCart cart() {
        System.out.println("쇼핑 카트 생성 시점");
        return new ShoppingCart();
    }

    @Bean
    public Product milk() {
        System.out.println("우유 생성 시점");
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        System.out.println("물 생성 시점");
        return new Beverage("지리산암반수", 3000, 500);
    }
}
