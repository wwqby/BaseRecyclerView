package com.example.baserecyclerview.demo;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baserecyclerview.R;
import com.example.baserecyclerview.components.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class MyAppAdapter extends BaseRecyclerViewAdapter<MyApp> {




    public MyAppAdapter(List<MyApp> dataList) {
        super(dataList);

    }

    @Override
    protected ViewHolder<MyApp> createHolder(View view) {

        return new MyAppHolder(view);
    }

    @Override
    protected View createItemView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myapp,parent,false);
    }

    @Override
    public void ItemClick(ViewHolder holder, MyApp data) {

        holder.itemView.setBackgroundColor(Color.RED);

    }



    @Override
    public void update(MyApp data, ViewHolder<MyApp> holder) {

    }


    class MyAppHolder extends ViewHolder<MyApp>{

        private ImageView mImageView;
        private TextView mTextView;


         MyAppHolder(View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.iv_my_app);
            mTextView=itemView.findViewById(R.id.tv_my_app);
        }

        @Override
        protected void onBindListener(ViewHolder<MyApp> holder) {

        }

        @Override
        protected void onBindChild(MyApp data) {

            this.mTextView.setText(data.getName());
            this.mImageView.setImageResource(data.getResId());

        }

    }
}
