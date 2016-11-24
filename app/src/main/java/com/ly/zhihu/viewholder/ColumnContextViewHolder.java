package com.ly.zhihu.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.ly.zhihu.R;
import com.ly.zhihu.model.ColumnContextBean;
import com.ly.zhihu.model.DailyBean;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ColumnContextViewHolder extends BaseViewHolder<ColumnContextBean.StoriesBean> {
    private TextView item_time;
    private ImageView item_image;
    private TextView item_title;
    private DailyBean bean = new DailyBean();


    public ColumnContextViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_daily_list);
        item_time = $(R.id.item_time);
        item_title = $(R.id.item_title);
        item_image = $(R.id.item_image);

    }

    @Override
    public void setData(ColumnContextBean.StoriesBean person) {
        super.setData(person);
        item_time.setText(person.getDisplay_date());
        item_title.setText(person.getTitle());
        Glide.with(getContext())
                .load(person.getImages().get(0))
                .placeholder(R.mipmap.account_avatar)
                .into(item_image);
    }
}
