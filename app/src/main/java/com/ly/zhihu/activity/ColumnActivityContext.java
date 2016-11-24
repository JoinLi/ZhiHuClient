package com.ly.zhihu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.R;
import com.ly.zhihu.adapter.ColumnContextAdapter;
import com.ly.zhihu.model.ColumnContextBean;
import com.ly.zhihu.model.ZhiHuApi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ColumnActivityContext extends AppCompatActivity implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    private Toolbar mToolbar;
    private EasyRecyclerView recyclerView;
    private ColumnContextAdapter adapter;
    private List<ColumnContextBean.StoriesBean> list = new ArrayList<ColumnContextBean.StoriesBean>();
    private int id;
    private String name;
    private int index;
    private int data;
    private static final String COLUMN_ID = "column_id";
    private static final String COLUMN_NAME = "column_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_context);
        initView();

    }

    private void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra(COLUMN_ID, -1);
            name = intent.getStringExtra(COLUMN_NAME);
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
        adapter = new ColumnContextAdapter(this);
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                adapter.stopMore();

            }
        });
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {
            @Override
            public void onErrorShow() {

            }

            @Override
            public void onErrorClick() {
                adapter.resumeMore();
            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                DailyActivityContext.lanuch(ColumnActivityContext.this, adapter.getAllData().get(position).getId());

            }
        });
        recyclerView.setRefreshListener(ColumnActivityContext.this);  //下拉刷新
        onRefresh();

    }


    @Override
    public void onLoadMore() {
        index = 1;
        //下个日期
        initData(ZhiHuApi.SECTION_CONTEXT + id + "/before/" + data);
    }

    @Override
    public void onRefresh() {
        index = 0;
        initData(ZhiHuApi.SECTION_CONTEXT + id);
    }

    private void initData(String path) {
        OkHttpUtils
                .get()
                .url(path)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (index == 0) {
                            adapter.clear();
                            adapter.pauseMore();
                        } else {
                            adapter.pauseMore();
                        }
                    }

                    @Override
                    public void onResponse(String string, int id) {
                        try {
                            if (index == 0) {
                                adapter.clear();
                                list.clear();
                            }
                            Gson gson = new Gson();
                            ColumnContextBean columnContextBean = gson.fromJson(string, ColumnContextBean.class);
                            data = columnContextBean.getTimestamp();
                            list = columnContextBean.getStories();
                            adapter.addAll(list);

                        } catch (Exception e) {
                            adapter.stopMore();
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
    public static void lanuch(Context context, int id, String name) {

        Intent mIntent = new Intent(context, ColumnActivityContext.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mIntent.putExtra(COLUMN_ID, id);
        mIntent.putExtra(COLUMN_NAME, name);
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
