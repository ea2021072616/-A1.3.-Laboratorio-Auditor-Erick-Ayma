package com.foto.indexlib.IndexBar.bean;

import com.foto.indexlib.a.a;
/* loaded from: classes.dex */
public abstract class BaseIndexBean implements a {
    private String baseIndexTag;

    public String getBaseIndexTag() {
        return this.baseIndexTag;
    }

    public BaseIndexBean setBaseIndexTag(String str) {
        this.baseIndexTag = str;
        return this;
    }

    @Override // com.foto.indexlib.a.a
    public String getSuspensionTag() {
        return this.baseIndexTag;
    }

    @Override // com.foto.indexlib.a.a
    public boolean isShowSuspension() {
        return true;
    }
}
