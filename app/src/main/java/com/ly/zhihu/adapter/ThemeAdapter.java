package com.ly.zhihu.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.model.ThemesDetails;
import com.ly.zhihu.viewholder.ThemeViewHolder;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class ThemeAdapter extends RecyclerArrayAdapter<ThemesDetails.OthersBean> {
    public ThemeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThemeViewHolder(parent);
    }
}
