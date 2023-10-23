package com.example.pokedexapi;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Pokemon {
    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private int height;

    @SerializedName("weight")
    private int weight;

    @SerializedName("sprites")
    private Sprites sprites;

    @SerializedName("types")
    private List<Type> types;

    public class Sprites {
        @SerializedName("front_default")
        private String frontDefault;

        public String getFrontDefault() {
            return frontDefault;
        }
    }

    public class Type {
        @SerializedName("type")
        private TypeName typeName;

        public TypeName getTypeName() {
            return typeName;
        }
    }

    public class TypeName {
        @SerializedName("name")
        private String name;

        public String getName() {
            return name;
        }
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getFrontImage() {
        return sprites.getFrontDefault();
    }

    public List<Type> getTypes() {
        return types;
    }
}

