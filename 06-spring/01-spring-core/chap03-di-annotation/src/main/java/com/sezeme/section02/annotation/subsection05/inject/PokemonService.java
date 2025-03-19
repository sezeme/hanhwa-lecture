package com.sezeme.section02.annotation.subsection05.inject;

import com.sezeme.section02.annotation.common.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")
public class PokemonService {

    /* @Inject : 자바 진영에서 제공하는 DI Annotation
    * @Autowired와 유사하게 타입을 통해 의존성 주입을 하며 @Named를 통해 빈 이름을 명시할 수 있따.
    * 필드, 세터, 생성자 주입이 가능하다.
    * */
    @Inject
    @Named("pikachu")
    private Pokemon pokemon;

    public void pokemonAttack() {
        pokemon.attack();
    }
}
