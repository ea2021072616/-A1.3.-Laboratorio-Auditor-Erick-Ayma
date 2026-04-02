package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public abstract class n extends RelativeLayout implements m {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1699a;

    /* renamed from: b  reason: collision with root package name */
    private com.facebook.ads.internal.view.n f1700b;

    static {
        f1699a = !n.class.desiredAssertionStatus();
    }

    public n(Context context) {
        super(context);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.internal.view.d.b.m
    public void a(com.facebook.ads.internal.view.n nVar) {
        this.f1700b = nVar;
        a_(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a_(com.facebook.ads.internal.view.n nVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.ads.internal.view.n getVideoView() {
        if (f1699a || this.f1700b != null) {
            return this.f1700b;
        }
        throw new AssertionError();
    }
}
