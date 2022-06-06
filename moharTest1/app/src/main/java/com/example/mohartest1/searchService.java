package com.example.mohartest1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface searchService {
    @GET("/v2/local/search/address.json")
    Call<kakao_data_address> searchAddressList(@Query("query") String address, @Header("Authorization") String apikey);

    @GET("/v2/local/search/keyword.json")
    Call<kakao_data_HairShop> searchKeywordList(@Query("query") String keyword, @Query("y") String latitude, @Query("x") String longitude, @Query("radius") int radius, @Header("Authorization") String apikey);
}
