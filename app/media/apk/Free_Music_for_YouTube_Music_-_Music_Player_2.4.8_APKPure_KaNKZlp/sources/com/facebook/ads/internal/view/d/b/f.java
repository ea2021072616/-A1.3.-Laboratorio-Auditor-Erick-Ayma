package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
/* loaded from: classes.dex */
public class f extends n implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f1662b;

    /* renamed from: c  reason: collision with root package name */
    private final s<com.facebook.ads.internal.view.d.a.j> f1663c;
    private final s<com.facebook.ads.internal.view.d.a.b> d;

    public f(Context context) {
        super(context);
        this.f1663c = new s<com.facebook.ads.internal.view.d.a.j>() { // from class: com.facebook.ads.internal.view.d.b.f.1
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.j> a() {
                return com.facebook.ads.internal.view.d.a.j.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.j jVar) {
                f.this.setVisibility(8);
            }
        };
        this.d = new s<com.facebook.ads.internal.view.d.a.b>() { // from class: com.facebook.ads.internal.view.d.b.f.2
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.b> a() {
                return com.facebook.ads.internal.view.d.a.b.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                f.this.setVisibility(0);
            }
        };
        this.f1662b = new ImageView(context);
        this.f1662b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f1662b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.ads.internal.view.d.b.n
    public void a_(com.facebook.ads.internal.view.n nVar) {
        nVar.getEventBus().a((r<s, q>) this.f1663c);
        nVar.getEventBus().a((r<s, q>) this.d);
        nVar.addOnLayoutChangeListener(this);
        super.a_(nVar);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int i9 = i4 - i2;
        int i10 = i3 - i;
        if (layoutParams.height == i9 && layoutParams.width == i10 && layoutParams.topMargin == i2 && layoutParams.leftMargin == i) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i10, i9);
        layoutParams2.topMargin = i2;
        layoutParams2.leftMargin = i;
        this.f1662b.setLayoutParams(new RelativeLayout.LayoutParams(i10, i9));
        if (this.f1662b.getParent() == null) {
            addView(this.f1662b);
        }
        setLayoutParams(layoutParams2);
    }

    public void setImage(@Nullable String str) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        new com.facebook.ads.internal.util.p(this.f1662b).a(str);
    }
}
