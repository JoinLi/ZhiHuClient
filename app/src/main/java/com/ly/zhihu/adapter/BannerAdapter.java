package com.ly.zhihu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.ly.zhihu.R;
import com.ly.zhihu.model.TopDailys;

import java.util.List;

public class BannerAdapter extends StaticPagerAdapter {

    private Context context;
    private List<TopDailys> list;
       public BannerAdapter(Context context,List<TopDailys> list){
           this.context = context;
           this.list = list;
        }

        @Override
        public View getView(ViewGroup container, final int position) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            TextView textView=new TextView(context);
//            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //加载图片
            Glide.with(context)
                    .load(list.get(position).getImage())
                    .placeholder(R.mipmap.account_avatar)
                    .into(imageView);
            //点击事件
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getUrl())));
                }
            });
            return imageView;
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }