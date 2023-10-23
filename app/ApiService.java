public class ApiService {
    private static final String BASE_URL = "https://sua.api.com/"; // Substitua pelo URL da sua API

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiServiceInterface getApiServiceInterface() {
        return getRetrofitInstance().create(ApiServiceInterface.class);
    }
}
