package com.fotoable.youtube.music.bean;

import java.util.List;
/* loaded from: classes.dex */
public class CategoryListBean {
    private List<CategoryBean> Decades;
    private List<CategoryBean> Genres;
    private List<CategoryBean> Moods;

    public List<CategoryBean> getMoods() {
        return this.Moods;
    }

    public void setMoods(List<CategoryBean> list) {
        this.Moods = list;
    }

    public List<CategoryBean> getDecades() {
        return this.Decades;
    }

    public void setDecades(List<CategoryBean> list) {
        this.Decades = list;
    }

    public List<CategoryBean> getGenres() {
        return this.Genres;
    }

    public void setGenres(List<CategoryBean> list) {
        this.Genres = list;
    }

    /* loaded from: classes.dex */
    public static class CategoryBean {
        private int categoryid;
        private String imgUrl;
        private String title;

        public int getCategoryid() {
            return this.categoryid;
        }

        public void setCategoryid(int i) {
            this.categoryid = i;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }
    }

    public String toString() {
        return "CategoryListBean{Moods=" + this.Moods + ", Decades=" + this.Decades + ", Genres=" + this.Genres + '}';
    }
}
