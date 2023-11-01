package com.example.pokedexapi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class PokemonDetalhes extends AppCompatActivity {
    private TextView nameTextView;
    private TextView heightTextView;
    private TextView weightTextView;
    private ImageView image;
    private TextView tipo;
    private TextView moves;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detalhes);

        // Recupere os extras passados pela MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            // Agora você tem o nome do Pokémon pesquisado

            // Implemente a lógica para obter os detalhes do Pokémon com base no nome
            // e atualize os elementos do layout com os dados do Pokémon
            fillPokemonDetails(name);
        }
    }

    private void fillPokemonDetails(String name) {
        // Aqui, você deve buscar os detalhes do Pokémon com base no nome 'name'
        // e, em seguida, atualizar os elementos do layout com os dados do Pokémon

        // Por exemplo, você pode usar o PokemonService para buscar os detalhes do Pokémon
        PokemonService pokemonService = new PokemonService();
        pokemonService.getPokemonInfoByName(name, new PokemonService.PokemonCallback() {
            @Override
            public void onSuccess(Pokemon pokemon) {
                // Os detalhes do Pokémon foram buscados com sucesso
                // Agora, você pode preencher os elementos do layout com os dados do Pokémon
                updateUIWithPokemonDetails(pokemon);
            }

            @Override
            public void onError(String message) {
                // Lidar com erros na chamada à API
            }
        });
    }

    private void updateUIWithPokemonDetails(Pokemon pokemon) {
        // Atualize os elementos do layout com os dados do Pokémon
        nameTextView = findViewById(R.id.textName);
        heightTextView = findViewById(R.id.textHeight);
        weightTextView = findViewById(R.id.textWeight);
        image = findViewById(R.id.detalhes);
        tipo = findViewById(R.id.textTypes);
        moves = findViewById(R.id.textMoves);

        nameTextView.setText("Nome: " + pokemon.getName());
        heightTextView.setText("Altura: " + pokemon.getHeight() + " cm");
        weightTextView.setText("Peso: " + pokemon.getWeight() + " kg");

        String types = "Tipo(s): ";
        List<Pokemon.Type> typeList = pokemon.getTypes();
        for (int i = 0; i < typeList.size(); i++) {
            String typeName = typeList.get(i).getTypeName().getName();
            types += typeName;
            if (i < typeList.size() - 1) {
                types += ", ";
            }
        }
        tipo.setText(types);

        String movess = "Movimentos: ";
        List<Pokemon.MoveInfo> moveList = pokemon.getMoves();
        int numberOfMovesToDisplay = Math.min(20, moveList.size()); // Limita a exibição a 10 movimentos ou ao número de movimentos disponíveis

        for (int i = 0; i < numberOfMovesToDisplay; i++) {
            String moveName = moveList.get(i).getMove().getName();
            movess += moveName;
            if (i < numberOfMovesToDisplay - 1) {
                movess += ", ";
            }
        }

        moves.setText("Movimentos: "+ movess);



        // Carregue e exiba a imagem da sprite do Pokémon
        String imageUrl = pokemon.getFrontImage();
        Glide.with(this)
                .load(imageUrl)
                .into(image);

        // Você também pode atualizar outros elementos, como tipos, etc.
    }

}
