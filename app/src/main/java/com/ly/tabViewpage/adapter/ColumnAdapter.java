package com.ly.tabViewpage.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.tabViewpage.model.ColumnBean;
import com.ly.tabViewpage.model.ThemesDetails;
import com.ly.tabViewpage.viewholder.ColumnViewHolder;
import com.ly.tabViewpage.viewholder.ThemeViewHolder;

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
