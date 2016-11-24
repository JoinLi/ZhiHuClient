package com.ly.zhihu.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.model.ColumnBean;
import com.ly.zhihu.viewholder.ColumnViewHolder;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class ColumnAdapter extends RecyclerArrayAdapter<ColumnBean.DataBean> {
    public ColumnAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColumnViewHolder(parent);
    }
}
