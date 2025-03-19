package com.sezeme.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/* @Primary : autowired로 동일 타입의 빈이 여러 개 찾아진 경우 우선시 할 타입을????*/
@Primary
@Component
public class Pikachu implements Pokemon {
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트⚡");
    }
}

