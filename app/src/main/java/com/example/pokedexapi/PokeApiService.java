package com.example.pokedexapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiService {
    @GET("pokemon/{pokemonId}")
    Call<Pokemon> getPokemonInfo(@Path("pokemonId") int pokemonId);
}
