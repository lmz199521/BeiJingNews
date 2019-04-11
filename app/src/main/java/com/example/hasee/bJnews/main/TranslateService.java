package com.example.hasee.bJnews.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lmz on 2019/04/11
 */
public interface TranslateService {

    @GET("translate?")
    Call<WordBean> translate(@Query("doctype")String doctype,@Query("type")String type,@Query("i")String i);
}
