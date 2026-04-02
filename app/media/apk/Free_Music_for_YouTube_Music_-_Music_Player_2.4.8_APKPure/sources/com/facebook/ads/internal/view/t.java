package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class t extends View {

    /* renamed from: a  reason: collision with root package name */
    private s f1787a;

    public t(Context context, s sVar) {
        super(context);
        this.f1787a = sVar;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.f1787a != null) {
            this.f1787a.a(i);
        }
    }
}
