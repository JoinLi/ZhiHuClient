package com.ly.zhihu.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.model.ThemeContextBean;
import com.ly.zhihu.viewholder.ThemeContextViewHolder;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class ThemeContextAdapter extends RecyclerArrayAdapter<ThemeContextBean.StoriesBean> {
    public ThemeContextAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThemeContextViewHolder(parent);
    }
}
