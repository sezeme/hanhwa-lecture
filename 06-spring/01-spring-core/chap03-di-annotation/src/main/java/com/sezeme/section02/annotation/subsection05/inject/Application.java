package com.sezeme.section02.annotation.subsection05.inject;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.sezeme.section02");

        PokemonService pokemonService = applicationContext.getBean(
                "pokemonServiceInject", PokemonService.class
        );

        pokemonService.pokemonAttack();
    }
}
