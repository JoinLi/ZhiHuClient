package com.ly.zhihu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.R;
import com.ly.zhihu.adapter.ThemeContextAdapter;
import com.ly.zhihu.model.ThemeContextBean;
import com.ly.zhihu.model.ZhiHuApi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ThemeActivityContext extends AppCompatActivity implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    private Toolbar mToolbar;
    private EasyRecyclerView recyclerView;
    private ThemeContextAdapter adapter;
    private ImageView mThemesBg;
    private TextView mThemesTitle;
    private List<ThemeContextBean.StoriesBean> list = new ArrayList<ThemeContextBean.StoriesBean>();
    private int id;
    private String name;
    private int index;
    private static final String THEME_ID = "theme_id";
    private static final String THEME_NAME = "theme_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_context);
        initView();

    }

    private void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra(THEME_ID, -1);
            name=intent.getStringExtra(THEME_NAME);
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(name);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            //设置返回按钮
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
//

        }
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ThemeContextAdapter(this);
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                adapter.stopMore();

            }
        });
        adapter.setNoMore(R.layout.view_nomore);

        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View headView = LayoutInflater.from(ThemeActivityContext.this).inflate(R.layout.layout_themes_context_head, parent, false);
                mThemesBg = (ImageView) headView.findViewById(R.id.type_image);
                mThemesTitle = (TextView) headView.findViewById(R.id.type_title);
//                imageView = new ImageView(ThemeActivityContext.this);
//                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(int) Utils.convertDpToPixel(240, ThemeActivityContext.this)));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return headView;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                DailyActivityContext.lanuch(ThemeActivityContext.this,adapter.getAllData().get(position).getId());

            }
        });
        recyclerView.setRefreshListener(ThemeActivityContext.this);  //下拉刷新
        onRefresh();

    }


    @Override
    public void onLoadMore() {
        adapter.stopMore();
    }

    @Override
    public void onRefresh() {
        index=0;
        initData(ZhiHuApi.THEME_CONTEXT + id);
    }

    private void initData(String path) {
        OkHttpUtils
                .get()
                .url(path)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String string, int id) {
                        try {
                            if (index==0){
                                adapter.clear();
                                list.clear();
                            }
                            Gson gson = new Gson();
                            ThemeContextBean themeContext = gson.fromJson(string, ThemeContextBean.class);
                            //设置图片
                            Glide.with(ThemeActivityContext.this).load(themeContext.getImage()).placeholder(R.mipmap.account_avatar).into(mThemesBg);
                            //设置文字
                            mThemesTitle.setText(themeContext.getDescription());
                            list = themeContext.getStories();
                            adapter.addAll(list);

                        } catch (Exception e) {
                            System.err.println("出错了");
                            e.printStackTrace();

                        }
                    }

                });


    }

    //    public static void lanuch(Context context, DailyBean dailyBean) {
//
//        Intent mIntent = new Intent(context, ThemeActivityContext.class);
//        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        mIntent.putExtra(EXTRA_DETAIL, dailyBean);
//        context.startActivity(mIntent);
//    }
//
    public static void lanuch(Context context, int id,String name) {

        Intent mIntent = new Intent(context, ThemeActivityContext.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mIntent.putExtra(THEME_ID, id);
        mIntent.putExtra(THEME_NAME, name);
        context.startActivity(mIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
