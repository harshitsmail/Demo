package com.example.demoimageloader.repository;

import android.app.Application;

import com.example.demoimageloader.models.MainDataBean;
import com.example.demoimageloader.retrofit.ApiInterface;
import com.example.demoimageloader.retrofit.RetrofitService;


import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListDataRepository {
    private static ApiInterface mRetrofitApiInterface;

    public ListDataRepository(Application application) {
        mRetrofitApiInterface = RetrofitService.createService(ApiInterface.class);
    }

    public MutableLiveData<ArrayList<MainDataBean>> getApiData(){
        MutableLiveData<ArrayList<MainDataBean>> mDataModel = new MutableLiveData<>();
        mRetrofitApiInterface.fetchList().enqueue(new Callback<ArrayList<MainDataBean>>() {
            @Override
            public void onResponse(Call<ArrayList<MainDataBean>> call, Response<ArrayList<MainDataBean>> response) {
                if (response.isSuccessful()){
                    mDataModel.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MainDataBean>> call, Throwable t) {
                mDataModel.setValue(null);
            }
        });
        return mDataModel;
    }

}
