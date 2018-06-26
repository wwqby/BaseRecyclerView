package com.example.baserecyclerview.components;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public interface AdapterCallback<T> {
    void update(T data, BaseRecyclerViewAdapter.ViewHolder<T> holder);
}
