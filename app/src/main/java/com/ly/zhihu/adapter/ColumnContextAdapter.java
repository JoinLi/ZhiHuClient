package com.ly.zhihu.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.model.ColumnContextBean;
import com.ly.zhihu.viewholder.ColumnContextViewHolder;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class ColumnContextAdapter extends RecyclerArrayAdapter<ColumnContextBean.StoriesBean> {
    public ColumnContextAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColumnContextViewHolder(parent);
    }
}
