package com.example.demoimageloader.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demoimageloader.MainActivityAdapter;
import com.example.demoimageloader.R;
import com.example.demoimageloader.models.MainDataBean;
import com.example.demoimageloader.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mMainActivityViewModel;
    private RecyclerView mRecyclerView;
    private MainActivityAdapter mAdapter;
    private ArrayList<MainDataBean> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initializeObserver();

    }


    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mDataList = new ArrayList<>();


        mAdapter = new MainActivityAdapter(this, mDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initializeObserver() {
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.getPlacesList().observe(this, new Observer<ArrayList<MainDataBean>>() {
            @Override
            public void onChanged(ArrayList<MainDataBean> listDataModel) {
                if (listDataModel != null) {
                    mDataList.clear();
                    mDataList.addAll(listDataModel);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
