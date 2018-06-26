package com.example.baserecyclerview.components;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public interface OnItemClickListener<T> {
    void ItemClick(BaseRecyclerViewAdapter.ViewHolder holder, T data);

}
