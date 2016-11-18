package com.ly.tabViewpage.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.ly.tabViewpage.R;
import com.ly.tabViewpage.Utils;
import com.ly.tabViewpage.activity.DailyActivityContext;
import com.ly.tabViewpage.adapter.BannerAdapter;
import com.ly.tabViewpage.adapter.PersonAdapter;
import com.ly.tabViewpage.model.DailyBean;
import com.ly.tabViewpage.model.DailyListBean;
import com.ly.tabViewpage.model.TopDailys;
import com.ly.tabViewpage.model.ZhiHuApi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


/**
 * @Auther: Joinli
 * @Date: 2016/7/9.
 * @description: 日报界面
 */
public class DailyFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TITLE = "日报";
    private EasyRecyclerView recyclerView;
    private PersonAdapter adapter;
    private RollPagerView header;
    private List<DailyBean> list = new ArrayList<DailyBean>();
    private List<TopDailys> topDailys = new ArrayList<TopDailys>();
    private int index;

    public static DailyFragment newInstance() {
        DailyFragment fragment = new DailyFragment();
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
        adapter = new PersonAdapter(getContext());
//        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(getActivity(),0.5f), Util.dip2px(getActivity(),72),0);
//        itemDecoration.setDrawLastItem(true);
//        itemDecoration.setDrawHeaderFooter(true);
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);

        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                header = new RollPagerView(getActivity());
                header.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.GRAY));
                header.setHintPadding(0, 0, 0, (int) Utils.convertDpToPixel(8, getActivity()));
                header.setPlayDelay(2000);
                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Utils.convertDpToPixel(200, getActivity())));
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                DailyActivityContext.lanuch(getActivity(),adapter.getAllData().get(position).getId());

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
        System.err.println("before" + list.get(0).getDate());
        initData(ZhiHuApi.BEFORE + list.get(0).getDate());
    }

    @Override
    public void onRefresh() {
        index = 0;
        initData(ZhiHuApi.LATEST);
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
                            if (index == 0) {//暂无数据
                                adapter.clear();
                                list.clear();
                                topDailys.clear();
                            }

//                            Type type = new TypeToken<List<DailyListBean>>() {
//                            }.getType();
                            Gson gson = new Gson();
                            DailyListBean status = gson.fromJson(string, DailyListBean.class);
                            list = status.getStories();
                            if (index == 0) {
                                topDailys = status.getTop_stories();
                                header.setAdapter(new BannerAdapter(getActivity(), topDailys));
                            }

                            list.get(0).setDate(status.getDate());
                            adapter.addAll(list);


                        } catch (Exception e) {
                            System.err.println("出错了");
                            e.printStackTrace();

                        }
                    }

                });


    }

}
