package com.ly.zhihu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ly.zhihu.R;
import com.ly.zhihu.model.DailyBean;
import com.ly.zhihu.model.DailyDetail;
import com.ly.zhihu.model.ZhiHuApi;
import com.ly.zhihu.util.HtmlUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/17.
 */
public class DailyActivityContext extends AppCompatActivity {
    private Toolbar mToolbar;
    private WebView mWebView;
    private ImageView mDetailImage;
    private TextView mDetailTitle;
    private TextView mDetailSource;
    private DailyBean mDaily;
    private int id;
    private static final String EXTRA_DETAIL = "extra_detail";
    private static final String EXTRA_ID = "extra_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_dateil);
        initView();

    }

    private void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            mDaily = intent.getParcelableExtra(EXTRA_DETAIL);
            id = intent.getIntExtra(EXTRA_ID,-1);
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mWebView = (WebView) findViewById(R.id.detail_web_view);
        mDetailImage = (ImageView) findViewById(R.id.detail_image);
        mDetailTitle = (TextView) findViewById(R.id.detail_title);
        mDetailSource = (TextView) findViewById(R.id.detail_source);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null)
        {
            //设置返回按钮
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
//

        }

//        mToolbar.setNavigationIcon(R.mipmap.back);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                finish();
//            }
//        });

        initData(ZhiHuApi.STORY + id);
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
                            Gson gson = new Gson();
                            DailyDetail dailyDetail = gson.fromJson(string, DailyDetail.class);

                            //设置图片
                            Glide.with(DailyActivityContext.this).load(dailyDetail.getImage()).placeholder(R.mipmap.account_avatar).into(mDetailImage);
                            //设置标题
                            mDetailTitle.setText(dailyDetail.getTitle());
                            //设置图片来源
                            mDetailSource.setText(dailyDetail.getImage_source());
                            //设置web内容加载
                            String htmlData = HtmlUtil.createHtmlData(dailyDetail);
                            mWebView.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);

                        } catch (Exception e) {
                            System.err.println("出错了");
                            e.printStackTrace();

                        }
                    }

                });


    }

    public static void lanuch(Context context, DailyBean dailyBean) {

        Intent mIntent = new Intent(context, DailyActivityContext.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mIntent.putExtra(EXTRA_DETAIL, dailyBean);
        context.startActivity(mIntent);
    }

    public static void lanuch(Context context, int id) {

        Intent mIntent = new Intent(context, DailyActivityContext.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mIntent.putExtra(EXTRA_ID, id);
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
