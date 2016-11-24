package com.ly.zhihu.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.ly.zhihu.R;
import com.ly.zhihu.model.DailyBean;

/**
 * Created by Mr.Jude on 2015/2/22.
 */
public class PersonViewHolder extends BaseViewHolder<DailyBean> {
    private TextView item_time;
    private ImageView item_image;
    private TextView item_title;
    int page;
    private DailyBean bean=new DailyBean();




    public PersonViewHolder(ViewGroup parent) {
        super(parent,R.layout.item_daily_list);
//        item_time = $(R.id.item_time);
        item_title = $(R.id.item_title);
        item_image = $(R.id.item_image);

    }
    public  int State(){

        if (bean.getDate().equals("")){
            page=R.layout.item_daily_list;
        }else{
            page=R.layout.item_daily_list_time;
        }

        return page;
    }

    @Override
    public void setData(final DailyBean person) {
//        item_time.setText(person.getDate());
        item_title.setText(person.getTitle());
        System.err.println(person.getImages().get(0));
        Glide.with(getContext())
                .load(person.getImages().get(0))
                .placeholder(R.mipmap.account_avatar)
                .into(item_image);
    }




}
