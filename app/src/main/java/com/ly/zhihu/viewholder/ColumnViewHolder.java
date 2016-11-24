package com.ly.zhihu.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.ly.zhihu.R;
import com.ly.zhihu.model.ColumnBean;

/**
 * Created by Administrator on 2016/11/17.
 *
 */
public class ColumnViewHolder extends BaseViewHolder<ColumnBean.DataBean> {
    private TextView item_type_name;
    private ImageView item_type_img;
    private TextView item_type_des;

    public ColumnViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_themes_daily);
        item_type_name = $(R.id.item_type_name);
        item_type_img = $(R.id.item_type_img);
        item_type_des = $(R.id.item_type_des);
    }

    @Override
    public void setData(ColumnBean.DataBean person) {
        super.setData(person);
        item_type_des.setText(person.getName());
        item_type_name.setText(person.getDescription());
        Glide.with(getContext())
                .load(person.getThumbnail())
                .placeholder(R.mipmap.account_avatar)
                .into(item_type_img);
    }
}
