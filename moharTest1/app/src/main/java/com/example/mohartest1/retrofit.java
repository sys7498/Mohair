package com.example.mohartest1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {

    private static retrofit INSTANCE;

    public static retrofit getRetrofit(){
        if(INSTANCE == null){
            INSTANCE = new retrofit();
        }
        return INSTANCE;
    }

    private retrofit(){

    }

    public searchService getSearchKeywordService(){
        Retrofit kakaoHairShopRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dapi.kakao.com/")
                .build();

        return kakaoHairShopRetrofit.create(searchService.class);
    }

    public searchService getSearchAddressService(){
        Retrofit kakaoAddressRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dapi.kakao.com/")
                .build();
        return kakaoAddressRetrofit.create(searchService.class);
    }
}
