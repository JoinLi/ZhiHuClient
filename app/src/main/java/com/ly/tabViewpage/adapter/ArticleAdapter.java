package com.ly.tabViewpage.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.tabViewpage.model.ArticleBean;
import com.ly.tabViewpage.model.ColumnBean;
import com.ly.tabViewpage.viewholder.ArticleViewHolder;
import com.ly.tabViewpage.viewholder.ColumnViewHolder;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class ArticleAdapter extends RecyclerArrayAdapter<ArticleBean.RecentBean> {
    public ArticleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(parent);
    }
}
