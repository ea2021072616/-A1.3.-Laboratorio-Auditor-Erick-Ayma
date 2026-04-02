package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
/* loaded from: classes.dex */
public class j extends n {

    /* renamed from: b  reason: collision with root package name */
    private final ProgressBar f1685b;

    /* renamed from: c  reason: collision with root package name */
    private final s<com.facebook.ads.internal.view.d.a.l> f1686c;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1686c = new s<com.facebook.ads.internal.view.d.a.l>() { // from class: com.facebook.ads.internal.view.d.b.j.1
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.l> a() {
                return com.facebook.ads.internal.view.d.a.l.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.l lVar) {
                j.this.setVisibility(8);
            }
        };
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.f1685b = new ProgressBar(getContext());
        this.f1685b.setIndeterminate(true);
        this.f1685b.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(this.f1685b, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.ads.internal.view.d.b.n
    public void a_(com.facebook.ads.internal.view.n nVar) {
        setVisibility(0);
        nVar.getEventBus().a((r<s, q>) this.f1686c);
    }
}
