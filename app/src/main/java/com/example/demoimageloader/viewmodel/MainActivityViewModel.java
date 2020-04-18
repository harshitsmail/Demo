package com.example.demoimageloader.viewmodel;

import android.app.Application;

import com.example.demoimageloader.models.MainDataBean;
import com.example.demoimageloader.repository.ListDataRepository;

import java.util.ArrayList;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<MainDataBean>> mDataModel;
    private ListDataRepository mListDataRepo;


    public MainActivityViewModel(Application application) {
        super(application);
        mListDataRepo = new ListDataRepository(application);
        mDataModel=mListDataRepo.getApiData();
    }

    public MutableLiveData<ArrayList<MainDataBean>> getPlacesList() {
        return mDataModel;
    }

}
