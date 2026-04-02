package com.fotoable.youtube.music.bean;

import java.util.List;
/* loaded from: classes.dex */
public class LocalPlayListParentBean {
    private List<LocalPlayListBean> localPlayListBeanList;
    private List<LocalPlayListModel> localPlayListModelList;

    public List<LocalPlayListBean> getLocalPlayListBeanList() {
        return this.localPlayListBeanList;
    }

    public void setLocalPlayListBeanList(List<LocalPlayListBean> list) {
        this.localPlayListBeanList = list;
    }

    public List<LocalPlayListModel> getLocalPlayListModelList() {
        return this.localPlayListModelList;
    }

    public void setLocalPlayListModelList(List<LocalPlayListModel> list) {
        this.localPlayListModelList = list;
    }
}
