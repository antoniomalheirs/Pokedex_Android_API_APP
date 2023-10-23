package com.example.pokedexapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.pokedexapi.Pokemon;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.menuitem, parent, false);
        }

        ImageView pokemonImageView = convertView.findViewById(R.id.pokemonImageView);
        TextView pokemonNameTextView = convertView.findViewById(R.id.pokemonNameTextView);
        TextView pokemonTypeView = convertView.findViewById(R.id.pokemonTypeView);

        Pokemon pokemon = pokemonList.get(position);

        // Define o nome do Pokémon
        pokemonNameTextView.setText(pokemon.getName());
        String types = "Tipo(s): ";
        List<Pokemon.Type> typeList = pokemon.getTypes();
        for (int i = 0; i < typeList.size(); i++) {
            String typeName = typeList.get(i).getTypeName().getName();
            types += typeName;
            if (i < typeList.size() - 1) {
                types += ", ";
            }
        }
        pokemonTypeView.setText(types);

        // Carrega a imagem do Pokémon usando Glide
        String imageUrl = pokemon.getFrontImage();
        Glide.with(context)
                .load(imageUrl)
                .into(pokemonImageView);

        return convertView;
    }
}
