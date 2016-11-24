package com.ly.zhihu.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.model.ArticleBean;
import com.ly.zhihu.viewholder.ArticleViewHolder;

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
