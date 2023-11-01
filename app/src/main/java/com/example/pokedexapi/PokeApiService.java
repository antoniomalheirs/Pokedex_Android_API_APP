package com.example.pokedexapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon/{pokemonId}")
    Call<Pokemon> getPokemonInfo(@Path("pokemonId") int pokemonId);

    @GET("pokemon/{pokemonName}")
    Call<Pokemon> getPokemonInfoByName(@Path("pokemonName") String pokemonName);
}

