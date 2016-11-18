package com.ly.tabViewpage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ly.tabViewpage.fragment.ArticleFragment;
import com.ly.tabViewpage.fragment.DailyFragment;
import com.ly.tabViewpage.fragment.ThemeFragment;
import com.ly.tabViewpage.fragment.ColumnFragment;

/**
 * @Auther: cpacm
 * @Date: 2016/7/9.
 * @description: 主页viewpager适配器
 */
public class BeatsFragmentAdapter extends FragmentPagerAdapter {

    private DailyFragment dailyFragment; //日报
    private ThemeFragment themeFragment; //主题
    private ColumnFragment columnFragment;//专栏
    private ArticleFragment articleFragment; //文章


    private final String[] titles;

    public BeatsFragmentAdapter(FragmentManager fm) {
        super(fm);
        titles = new String[]{DailyFragment.TITLE, ThemeFragment.TITLE, ColumnFragment.TITLE, ArticleFragment.TITLE};
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (dailyFragment == null)
                    dailyFragment = DailyFragment.newInstance();
                return dailyFragment;
            case 1:
                if (themeFragment == null)
                    themeFragment = ThemeFragment.newInstance();
                return themeFragment;
            case 2:
                if (columnFragment == null)
                    columnFragment = ColumnFragment.newInstance();
                return columnFragment;
            case 3:
                if (articleFragment == null)
                    articleFragment = ArticleFragment.newInstance();
                return articleFragment;


        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
