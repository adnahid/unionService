package com.example.unionservice.Api2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static Retrofit retrofit = null;
    private static final String BASEURL = "https://services.hanselandpetal.com/feeds/";


    public static Retrofit GetRettrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
