package com.ly.tabViewpage.model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ArticleBean {

    /**
     * news_id : 8975412
     * url : http://news-at.zhihu.com/api/2/news/8975412
     * thumbnail : http://pic3.zhimg.com/fa702ff3e763ca90a451dc1b798ab56e.jpg
     * title : 瞎扯 · 如何正确地吐槽
     */

    private List<RecentBean> recent;

    public List<RecentBean> getRecent() {
        return recent;
    }

    public void setRecent(List<RecentBean> recent) {
        this.recent = recent;
    }

    public static class RecentBean {
        private int news_id;
        private String url;
        private String thumbnail;
        private String title;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
