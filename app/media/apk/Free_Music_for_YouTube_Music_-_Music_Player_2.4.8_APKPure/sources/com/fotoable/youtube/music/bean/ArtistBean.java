package com.fotoable.youtube.music.bean;

import com.foto.indexlib.IndexBar.bean.BaseIndexBean;
/* loaded from: classes.dex */
public class ArtistBean extends BaseIndexBean {
    private int artistsid;
    private String desc;
    private String group;
    private String imgUrl;
    private boolean isTop;
    private String name;

    public int getArtistsid() {
        return this.artistsid;
    }

    public void setArtistsid(int i) {
        this.artistsid = i;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setTop(boolean z) {
        this.isTop = z;
    }

    public boolean isTop() {
        return this.isTop;
    }

    @Override // com.foto.indexlib.IndexBar.bean.BaseIndexBean, com.foto.indexlib.a.a
    public boolean isShowSuspension() {
        return !this.isTop;
    }
}
