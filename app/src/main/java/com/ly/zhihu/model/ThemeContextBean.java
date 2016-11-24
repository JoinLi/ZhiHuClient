package com.ly.zhihu.model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */
public class ThemeContextBean {

    /**
     * stories : [{"images":["http://pic3.zhimg.com/5e83b433111ce3e74a97b022c1d901a6.jpg"],"type":0,"id":7566325,"title":"游戏公司中的「音频组」是干什么的？"},{"images":["http://pic2.zhimg.com/bfa0edf4e65f59a27ba520b6af529445.jpg"],"type":0,"id":7482771,"title":"对于古典钢琴这种大师都很难不出错的事情，为什么不用机器人来完成？"},{"images":["http://pic4.zhimg.com/5aa1ca52f4785e93c949c842fc6d86df.jpg"],"type":0,"id":7474790,"title":"Kevin Hwang：录音混音母带，放一起讲吧，反正他们都是神职人员\u2026\u2026"},{"images":["http://pic2.zhimg.com/71f849922f7613132f78f84ba15ae001_t.jpg"],"type":0,"id":7274580,"title":"结束大响度人人有责！一定要了解的 Loudness War 响度战争。"},{"type":0,"id":4777739,"title":"如何欣赏具象音乐（Musique Concrète）？"},{"images":["http://pic1.zhimg.com/788bc920b0303bcdcc29f27a8f3d993c_t.jpg"],"type":0,"id":7197121,"title":"一场电子音乐演出，到底是称作「DJ Set」还是「Live Set」呢？"},{"images":["http://pic2.zhimg.com/78eeb0b8b30c6ede1a8bed748f47c3a5_t.jpg"],"type":1,"id":7113768,"title":"\u201c假吉他行家\u201d的10个征兆"},{"images":["http://pic4.zhimg.com/363ae20b14216ee9010d6ed1c2f61ed7_t.jpg"],"type":1,"id":7113340,"title":"认识版权标记，选择最合适的授权规范！"},{"type":0,"id":7107637,"title":"在音频发烧圈子里面有哪些好笑的玄学段子？"},{"images":["http://pic4.zhimg.com/506796e32009e32427d0fa06b978af1b_t.jpg"],"type":1,"id":7098064,"title":"想知道世界人民夏天都在听啥？看看 Spotify 夏日播放榜单"},{"images":["http://pic4.zhimg.com/1f83d5617a4aa77e737bc1cfa809cc2f_t.jpg"],"type":1,"id":7093929,"title":"任性！女汉子麦莉发布了包含 23 首单曲的免费专辑"},{"images":["http://pic3.zhimg.com/95aab9cabf6e939f1a1b0d986d93aa9e_t.jpg"],"type":0,"id":7085383,"title":"1990，承上启下，奠定未来"},{"type":1,"id":7087730,"title":"Diplo 和 Skrillex 揭露热单 \u201cWhere Are U Now\u201d 诞生过程"},{"images":["http://pic3.zhimg.com/e1b278fae7ca124fbfc69fc76fae73e6_t.jpg"],"type":1,"id":7085629,"title":"别黑我，做母带不只是把音量调大一点"},{"images":["http://pic4.zhimg.com/76a54379671c664c3d077e769553664f_t.jpg"],"type":1,"id":7082742,"title":"你家猫听了这段音乐有反应吗？"},{"images":["http://pic4.zhimg.com/26f81df331a78a93e34011dc3f16b623_t.jpg"],"type":0,"id":7078585,"title":"我唸《唸歌者》：评一本台湾饶舌乐的音乐民族志"},{"type":0,"id":7043078,"title":"一首歌的制作人和编曲人分别要做那些工作？"}]
     * description : 有音乐就很好
     * background : http://p1.zhimg.com/02/17/02176dbeefe7f0a54c0563f5533fa4da.jpg
     * color : 1564695
     * name : 音乐日报
     * image : http://p3.zhimg.com/fb/0c/fb0cafb337fd84bd6a08f5fe1a561401.jpg
     * editors : [{"url":"http://www.zhihu.com/people/3asic","bio":"录音师，电子音乐制作人","id":51,"avatar":"http://pic1.zhimg.com/7c0252b19accff6cf0de8ec789508b68_m.jpg","name":"贝塞克"},{"url":"http://www.zhihu.com/people/educk","bio":"《电音志》杂志主编","id":32,"avatar":"http://pic4.zhimg.com/5e02f4dc3_m.jpg","name":"电板鸭"}]
     * image_source :
     */

    private String description;
    private String background;
    private int color;
    private String name;
    private String image;
    private String image_source;
    /**
     * images : ["http://pic3.zhimg.com/5e83b433111ce3e74a97b022c1d901a6.jpg"]
     * type : 0
     * id : 7566325
     * title : 游戏公司中的「音频组」是干什么的？
     */

    private List<StoriesBean> stories;
    /**
     * url : http://www.zhihu.com/people/3asic
     * bio : 录音师，电子音乐制作人
     * id : 51
     * avatar : http://pic1.zhimg.com/7c0252b19accff6cf0de8ec789508b68_m.jpg
     * name : 贝塞克
     */

    private List<EditorsBean> editors;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<EditorsBean> getEditors() {
        return editors;
    }

    public void setEditors(List<EditorsBean> editors) {
        this.editors = editors;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

    public static class EditorsBean {
        private String url;
        private String bio;
        private int id;
        private String avatar;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
