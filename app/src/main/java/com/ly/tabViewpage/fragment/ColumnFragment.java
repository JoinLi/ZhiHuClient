package com.ly.tabViewpage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.tabViewpage.R;
import com.ly.tabViewpage.adapter.ColumnAdapter;
import com.ly.tabViewpage.model.ColumnBean;
import com.ly.tabViewpage.model.ZhiHuApi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


/**
 * @Auther: Joinli
 * @Date: 2016/7/9.
 * @description: 专栏界面
 */
public class ColumnFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TITLE = "专栏";
    private EasyRecyclerView recyclerView;
    private ColumnAdapter adapter;
    private List<ColumnBean.DataBean> list = new ArrayList<ColumnBean.DataBean>();

    public static ColumnFragment newInstance() {
        ColumnFragment fragment = new ColumnFragment();

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initView() {
        recyclerView =  findView(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ColumnAdapter(getContext());
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);

        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {


                return true;
            }
        });
        recyclerView.setRefreshListener(this);  //下拉刷新

    }

    @Override
    protected void initData() {
        onRefresh();
    }


    @Override
    public void onLoadMore() {
        adapter.stopMore();
    }

    @Override
    public void onRefresh() {
        initData(ZhiHuApi.SECTIONS);
    }

    private void initData(String path) {
        OkHttpUtils
                .get()
                .url(path)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        adapter.stopMore();
                    }

                    @Override
                    public void onResponse(String string, int id) {
                        try {
//                            if (page == 1) {//暂无数据
//                                adapter.clear();
//                                list.clear();
//                            }
//                            Type type = new TypeToken<List<DailyListBean>>() {
//                            }.getType();
                            Gson gson = new Gson();
                            ColumnBean status = gson.fromJson(string, ColumnBean.class);
                            list = status.getData();
                            adapter.addAll(list);

                        } catch (Exception e) {
                            System.err.println("出错了");
                            e.printStackTrace();

                        }
                    }

                });


    }
}
