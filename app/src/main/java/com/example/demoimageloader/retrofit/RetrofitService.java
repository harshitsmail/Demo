package com.example.wiprocodebasedemo.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit service class here a request
 */
public class RetrofitService {
    // We have added our base url here
    private static String BASE_URL="http://pastebin.com/raw/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
