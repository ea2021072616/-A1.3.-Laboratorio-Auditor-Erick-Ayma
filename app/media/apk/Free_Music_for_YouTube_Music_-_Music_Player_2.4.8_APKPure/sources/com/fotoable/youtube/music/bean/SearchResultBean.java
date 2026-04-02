package com.fotoable.youtube.music.bean;

import java.util.List;
/* loaded from: classes.dex */
public class SearchResultBean {
    private String etag;
    private List<SearchItemBean> items;
    private String kind;
    private String nextPageToken;
    private PageInfoBean pageInfo;
    private String regionCode;

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public void setNextPageToken(String str) {
        this.nextPageToken = str;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public PageInfoBean getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfoBean) {
        this.pageInfo = pageInfoBean;
    }

    public List<SearchItemBean> getItems() {
        return this.items;
    }

    public void setItems(List<SearchItemBean> list) {
        this.items = list;
    }
}
