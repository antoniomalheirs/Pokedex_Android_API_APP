package com.example.pokedexapi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonService {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    private PokeApiService apiService;
    private Retrofit retrofit;

    public PokemonService() {

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(PokeApiService.class);
        }
    }

    public void getPokemon(int pokemonId, final PokemonCallback callback) {
        Call<Pokemon> call = apiService.getPokemonInfo(pokemonId);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body();
                    callback.onSuccess(pokemon);
                } else {
                    callback.onError("Erro na resposta da API");
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                callback.onError("Falha na chamada à API");
            }
        });
    }

    public void getPokemonInfoByName(String name, final PokemonCallback callback) {
        Call<Pokemon> call = apiService.getPokemonInfoByName(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body();
                    callback.onSuccess(pokemon);
                } else {
                    callback.onError("Erro na resposta da API");
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                callback.onError("Falha na chamada à API");
            }
        });
    }


    public interface PokemonCallback {
        void onSuccess(Pokemon pokemon);

        void onError(String message);
    }
}

