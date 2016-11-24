package com.ly.zhihu.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ly.zhihu.R;
import com.ly.zhihu.activity.DailyActivityContext;
import com.ly.zhihu.adapter.ArticleAdapter;
import com.ly.zhihu.model.ArticleBean;
import com.ly.zhihu.model.ZhiHuApi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * @Auther: Joinli
 * @Date: 2016/7/9.
 * @description: 文章界面
 */
public class ArticleFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TITLE = "文章";
    private EasyRecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<ArticleBean.RecentBean> list = new ArrayList<ArticleBean.RecentBean>();
    private int index;
    public static ArticleFragment newInstance() {
        ArticleFragment fragment = new ArticleFragment();
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
        adapter = new ArticleAdapter(getContext());
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
                DailyActivityContext.lanuch(getActivity(),adapter.getAllData().get(position).getNews_id());
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
        index=0;
        initData(ZhiHuApi.HOT);
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
                            ArticleBean status = gson.fromJson(string, ArticleBean.class);
                            list = status.getRecent();
                            adapter.addAll(list);

                        } catch (Exception e) {
                            adapter.stopMore();
                            e.printStackTrace();

                        }
                    }

                });


    }
}