package com.sezeme.section02.annotation.subsection01.primary;

import com.sezeme.section02.annotation.common.Pokemon;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {
    private Pokemon pokemon;

    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon; // 생성자를 통해 의존성 주입
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
