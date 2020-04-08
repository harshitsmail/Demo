package com.example.wiprocodebasedemo.viewmodel;

import android.app.Application;

import com.example.wiprocodebasedemo.models.MainDataBean;
import com.example.wiprocodebasedemo.repository.ListDataRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
