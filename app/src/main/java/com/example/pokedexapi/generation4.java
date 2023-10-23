package com.example.pokedexapi;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokedexapi.Pokemon;
import com.example.pokedexapi.PokemonAdapter;
import com.example.pokedexapi.PokemonService;
import com.example.pokedexapi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

public class generation4 extends AppCompatActivity {
    private ListView pokemonListView;
    private PokemonService pokemonService;
    private List<Pokemon> pokemonList;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generation4);

        pokemonListView = findViewById(R.id.pokemonListView);
        pokemonService = new PokemonService();
        pokemonList = new ArrayList<>();
        adapter = new PokemonAdapter(this, pokemonList);

        pokemonListView.setAdapter(adapter);

        // Busque informações sobre os Pokémon da primeira geração (IDs de 1 a 151)
        for (int i = 387; i <= 493; i++) {
            fetchPokemonInfo(i);
        }
    }

    private void fetchPokemonInfo(int pokemonId) {
        pokemonService.getPokemon(pokemonId, new PokemonService.PokemonCallback() {
            @Override
            public void onSuccess(Pokemon pokemon) {
                // Adicione o Pokémon à lista
                pokemonList.add(pokemon);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String message) {
                // Lidar com erros na chamada à API
            }
        });
    }
}
