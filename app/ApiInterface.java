import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("pokemon/{pokemonId}")
    Call<Pokemon> getPokemonInfo(@Path("pokemonId") int pokemonId);
}



