package com.example.baserecyclerview.components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder<T>> implements View.OnClickListener,OnItemClickListener<T>, AdapterCallback<T>{
    private List<T> dataList;
    private OnItemClickListener<T> mListener;



    List<T> getDataList() {
        return dataList;
    }

    //TODO 实现OnItemClickListener接口 ,自定义的点击事件需要在这里设置
    public BaseRecyclerViewAdapter(List<T> dataList) {
        this.dataList = dataList;
        this.mListener=this;
    }

    @Override
    public BaseRecyclerViewAdapter.ViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= createItemView(parent);
        view.setOnClickListener(this);
        ViewHolder<T> holder= createHolder(view);
        holder.callback=this;
        view.setTag(holder);
        return holder;
    }

    protected abstract ViewHolder<T> createHolder(View view);
    protected abstract View createItemView(ViewGroup parent);

    @Override
    public void onBindViewHolder(BaseRecyclerViewAdapter.ViewHolder<T> holder, int position) {
        T data=dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(View v) {
        ViewHolder holder=(ViewHolder) v.getTag();
            int position=holder.getAdapterPosition();
            this.mListener.ItemClick( holder,dataList.get(position));
    }


//    TODO 更新adapter数据的方法,可以重写
//    @Override
//    public void update(T data, ViewHolder<T> holder) {
//        int position=holder.getAdapterPosition();
//        if (position>=0){
//            dataList.remove(position);
//            dataList.add(position,data);
//            notifyItemChanged(position);
//        }
//    }



    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder{
        T data;
        private AdapterCallback<T> callback;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        void bind(T data) {
            this.data=data;
            onBindChild(data);
            onBindListener(this);
        }

//          TODO 给子控件绑定监听器,点击itemView的实现由接口OnItemClickListener实现,ItemView中的子控件点击效果由onBindListener实现.
        protected abstract void onBindListener(ViewHolder<T> holder);
//          TODO 绑定item视图中的子控件
        protected abstract void onBindChild(T data);

//        回调接口方法update()
        void updateData(T data){
            if (callback!=null){
                this.callback.update(data,this);
            }
        }
    }




}
