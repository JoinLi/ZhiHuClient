package com.ly.zhihu.model;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ZhiHuApi {
    public static final String ZHIHU_DAILY_URL = "http://news-at.zhihu.com/api/4/";    //知乎Api
    //    日报
    public static final String LATEST = ZHIHU_DAILY_URL+"stories/latest";// 最新消息
    public static final String BEFORE = ZHIHU_DAILY_URL+"stories/before/";// 下个日期（下一页） 参数 before/20161116
    public static final String IMAGE = ZHIHU_DAILY_URL+"start-image/";  // 启动图 start-image/1080*1776
    public static final String STORY = ZHIHU_DAILY_URL+"story/";// 详细信息
    //     主题
   public static final String THEMES = ZHIHU_DAILY_URL+"themes";//

    public static final String THEME_CONTEXT = ZHIHU_DAILY_URL+"theme/";//  主题具体内容

    //     专栏
    public static final String SECTIONS = ZHIHU_DAILY_URL+"sections";//
    public static final String SECTION_CONTEXT = ZHIHU_DAILY_URL+"section/";//专栏具体内容
    //     文章
    public static final String HOT = ZHIHU_DAILY_URL+"news/hot";//





}
