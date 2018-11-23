package com.iav.senamlantai.rest;

import com.iav.senamlantai.model.DataMenuModel;
import com.iav.senamlantai.model.ImageSliderModel;
import com.iav.senamlantai.model.LatihanSoalModel;
import com.iav.senamlantai.model.MenuModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("exec")
    Call<ArrayList<MenuModel>> getMenu(@Query("action") String action,
                                       @Query("sheetName") String sheetName);

    @GET("exec")
    Call<ArrayList<DataMenuModel>> getDataMenu(@Query("action") String action,
                                               @Query("sheetName") String sheetName);

    @GET("exec")
    Call<ArrayList<LatihanSoalModel>> getLatihanSoal(@Query("action") String action,
                                                     @Query("sheetName") String sheetName);

    @GET("exec")
    Call<ArrayList<ImageSliderModel>> getImageSlider(@Query("action") String action,
                                                     @Query("sheetName") String sheetName);


}