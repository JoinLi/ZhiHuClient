package com.ly.zhihu.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.ly.zhihu.R;
import com.ly.zhihu.model.ThemeContextBean;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ThemeContextViewHolder extends BaseViewHolder<ThemeContextBean.StoriesBean> {
    private TextView item_time;
    private ImageView item_image;
    private TextView item_title;


    public ThemeContextViewHolder(ViewGroup parent) {
        super(parent,R.layout.item_daily_list);
        item_title = $(R.id.item_title);
        item_image = $(R.id.item_image);

    }


    @Override
    public void setData(ThemeContextBean.StoriesBean person) {
        super.setData(person);
        item_title.setText(person.getTitle());
        if (person.getImages()!=null&&!person.getImages().equals("")){
            Glide.with(getContext())
                    .load(person.getImages().get(0))
                    .placeholder(R.mipmap.account_avatar)
                    .into(item_image);
        }



    }
}
