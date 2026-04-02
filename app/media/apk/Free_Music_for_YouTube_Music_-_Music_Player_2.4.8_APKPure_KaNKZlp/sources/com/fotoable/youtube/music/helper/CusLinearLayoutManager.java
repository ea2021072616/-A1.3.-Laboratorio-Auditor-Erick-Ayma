package com.fotoable.youtube.music.helper;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class CusLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2732a;

    public CusLinearLayoutManager(Context context) {
        super(context);
        this.f2732a = true;
    }

    public CusLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.f2732a = true;
    }

    public CusLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2732a = true;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f2732a && super.canScrollVertically();
    }
}
