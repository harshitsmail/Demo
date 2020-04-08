package com.example.wiprocodebasedemo.retrofit;

import com.example.wiprocodebasedemo.models.MainDataBean;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

// Here all the request inside the project are determined with their endpoints
public interface ApiInterface {

    @GET("wgkJgazE")
    Call<ArrayList<MainDataBean>> fetchList();

}
