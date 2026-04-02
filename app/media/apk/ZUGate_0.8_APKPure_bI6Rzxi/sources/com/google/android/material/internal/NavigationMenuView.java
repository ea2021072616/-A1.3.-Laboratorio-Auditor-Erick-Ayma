package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import h.c0;
import h.o;
/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements c0 {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setLayoutManager(new LinearLayoutManager(1));
    }

    @Override // h.c0
    public final void a(o oVar) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
