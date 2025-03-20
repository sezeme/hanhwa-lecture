package com.sezeme.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    @PostConstruct
    public void openShop() {
        System.out.println("사장님이 가게 문을 엽니다. 이제 쇼핑을 하실 수 있습니다.");
    }
    @PreDestroy
    public void closeShop() {
        System.out.println("사장님이 가게 문을 닫습니다. 이제 쇼핑을 하실 수 없습니다.");
    }
}
