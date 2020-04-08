package com.example.wiprocodebasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imageloader.ImageLoader;
import com.example.wiprocodebasedemo.models.MainDataBean;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> {
    private ArrayList<MainDataBean> mDataList;
    private Context mContext;

    public MainActivityAdapter(Context context, ArrayList<MainDataBean> dataList) {
        mDataList = dataList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MainDataBean rowData = mDataList.get(position);

//        holder.image.set;
        new ImageLoader(mContext).DisplayImage(rowData.getUrls().getRaw(), holder.image);
//        if (rowData.getTitle() != null) {
//            holder.title.setText("" + rowData.getTitle());
//        }
//        if (rowData.getDescription() != null) {
//            holder.subText.setText("" + rowData.getDescription());
//        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subText;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.img_background);
//            subText = (TextView) view.findViewById(R.id.tv_subtext);
//            title = (TextView) view.findViewById(R.id.tv_title);
        }
    }


}