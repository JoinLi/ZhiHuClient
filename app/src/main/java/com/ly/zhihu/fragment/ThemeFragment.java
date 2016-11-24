package com.ly.zhihu.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.R;
import com.ly.zhihu.activity.ThemeActivityContext;
import com.ly.zhihu.adapter.ThemeAdapter;
import com.ly.zhihu.model.ThemesDetails;
import com.ly.zhihu.model.ZhiHuApi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * @Auther: Joinli
 * @Date: 2016/7/9.
 * @description: 主题界面
 */
public class ThemeFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TITLE = "主题";
    private EasyRecyclerView recyclerView;
    private ThemeAdapter adapter;
    private List<ThemesDetails.OthersBean> list = new ArrayList<ThemesDetails.OthersBean>();
    private int index;

    public static ThemeFragment newInstance() {
        ThemeFragment fragment = new ThemeFragment();
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initView() {
        recyclerView = findView(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ThemeAdapter(getContext());
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, this);
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
                ThemeActivityContext.lanuch(getActivity(), adapter.getAllData().get(position).getId(), adapter.getAllData().get(position).getName());

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
        index = 1;
        adapter.stopMore();
    }

    @Override
    public void onRefresh() {
        index = 0;
        initData(ZhiHuApi.THEMES);
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
                            if (index == 0) {//暂无数据
                                adapter.clear();
                                list.clear();


                            }

//                            Type type = new TypeToken<List<DailyListBean>>() {
//                            }.getType();
                            Gson gson = new Gson();
                            ThemesDetails status = gson.fromJson(string, ThemesDetails.class);
                            list = status.getOthers();
//                            list.get(0).setDate(status.getDate());
                            adapter.addAll(list);

                        } catch (Exception e) {
                            adapter.stopMore();
                            e.printStackTrace();

                        }
                    }

                });


    }
}
