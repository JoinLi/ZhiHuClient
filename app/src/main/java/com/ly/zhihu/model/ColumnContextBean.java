package com.ly.zhihu.model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ColumnContextBean {

    /**
     * timestamp : 1478521200
     * stories : [{"images":["http://pic1.zhimg.com/bb3013cd702700e7fe8bfbad04781960.jpg"],"date":"20161111","display_date":"11 月 11 日","id":8969758,"title":"双十一 · 狂欢了八年，买买买已经不是重点"},{"images":["http://pic1.zhimg.com/a26340666020fbdbe42f158b3e033a98.jpg"],"date":"20161110","display_date":"11 月 10 日","id":8967161,"title":"双十一 · 「大家都别买，商家库存大，后面肯定更便宜」"},{"images":["http://pic3.zhimg.com/7257ad2cd58275798d14fb703b84d596.jpg"],"date":"20161109","display_date":"11 月 9 日","id":8962073,"title":"双十一 · 我以为我买的「保暖内衣」真的能「保暖」"},{"display_date":"11 月 8 日","title":"双十一 · 天猫和京东的广告又打起来了？（多图）","date":"20161108","images":["http://pic3.zhimg.com/0a71145a81727fc1cebc6489b46df6da.jpg"],"multipic":true,"id":8961188},{"images":["http://pic1.zhimg.com/e5c7b92eff70e937559a4099f9c3ce34.jpg"],"date":"20161107","display_date":"11 月 7 日","id":8958033,"title":"双十一 · 为什么我买了一大堆又发现自己其实并不需要？"}]
     * name : 双十一
     */

    private int timestamp;
    private String name;
    /**
     * images : ["http://pic1.zhimg.com/bb3013cd702700e7fe8bfbad04781960.jpg"]
     * date : 20161111
     * display_date : 11 月 11 日
     * id : 8969758
     * title : 双十一 · 狂欢了八年，买买买已经不是重点
     */

    private List<StoriesBean> stories;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        private String date;
        private String display_date;
        private int id;
        private String title;
        private List<String> images;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDisplay_date() {
            return display_date;
        }

        public void setDisplay_date(String display_date) {
            this.display_date = display_date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
