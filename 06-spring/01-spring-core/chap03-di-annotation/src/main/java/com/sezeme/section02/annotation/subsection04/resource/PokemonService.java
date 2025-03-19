package com.sezeme.section02.annotation.subsection04.resource;

import com.sezeme.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

    /* @Resource : 자바 진영에서 제공하는 DI Annotation
    * @Autowired와 달리 name 속성 값으로 의존성 주입을 할 수 있고 필드 주입, 세터 주입이 가능하다.
    * 만약 List<Pokemon> 타입이라면 name 속성을 생략하면 3개의 bean이 담긴다.
    * (이름 -> 타입 순서로 처리)
    *  */
    @Resource(name = "squirtle")
    private Pokemon pokemon;

    public void pokemonAttack() {
        pokemon.attack();
    }
}
