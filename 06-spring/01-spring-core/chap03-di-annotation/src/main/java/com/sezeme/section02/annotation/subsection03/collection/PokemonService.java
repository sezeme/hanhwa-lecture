package com.sezeme.section02.annotation.subsection03.collection;

import com.sezeme.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 컬렉션 타입으로 의존성 주입을 받게 되면 해당 타입의 등록 된 빈이 모두 주입 된다. */
    private List<Pokemon> pokemons;

    public PokemonService(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void pokemonAttack() {
        pokemons.forEach(Pokemon::attack);
    }
}
