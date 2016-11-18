package com.ly.tabViewpage.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.ly.tabViewpage.R;
import com.ly.tabViewpage.model.ThemesDetails;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ThemeViewHolder extends BaseViewHolder<ThemesDetails.OthersBean> {
    private TextView item_type_name;
    private ImageView item_type_img;
    private TextView item_type_des;

    public ThemeViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_themes_daily);
        item_type_name = $(R.id.item_type_name);
        item_type_img = $(R.id.item_type_img);
        item_type_des = $(R.id.item_type_des);
    }

    @Override
    public void setData(ThemesDetails.OthersBean person) {
        super.setData(person);
        item_type_des.setText(person.getDescription());
        item_type_name.setText(person.getName());
        Glide.with(getContext())
                .load(person.getThumbnail())
                .placeholder(R.mipmap.account_avatar)
                .into(item_type_img);
    }
}
