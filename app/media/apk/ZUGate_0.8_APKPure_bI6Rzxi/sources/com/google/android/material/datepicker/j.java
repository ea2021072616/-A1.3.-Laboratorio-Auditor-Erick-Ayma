package com.google.android.material.datepicker;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o0;
/* loaded from: classes.dex */
public final class j extends o0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f2120a;

    public j(l lVar) {
        this.f2120a = lVar;
        w.d(null);
        w.d(null);
    }

    @Override // androidx.recyclerview.widget.o0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        if ((recyclerView.getAdapter() instanceof y) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            y yVar = (y) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            int i5 = l.f2124s;
            this.f2120a.getClass();
            throw null;
        }
    }
}
