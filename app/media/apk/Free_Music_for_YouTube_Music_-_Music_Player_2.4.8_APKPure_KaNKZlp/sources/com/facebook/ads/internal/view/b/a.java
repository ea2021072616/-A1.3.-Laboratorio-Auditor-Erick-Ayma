package com.facebook.ads.internal.view.b;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.k;
import com.facebook.ads.internal.view.m;
/* loaded from: classes.dex */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private m f1599a;

    /* renamed from: b  reason: collision with root package name */
    private int f1600b;

    public a(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        super(context);
        setOrientation(1);
        setVerticalGravity(16);
        this.f1599a = new m(getContext(), 2);
        this.f1599a.setMinTextSize(nativeAdViewAttributes.getTitleTextSize() - 2);
        this.f1599a.setText(nativeAd.getAdTitle());
        k.a(this.f1599a, nativeAdViewAttributes);
        this.f1599a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f1599a);
        this.f1600b = nativeAd.getAdTitle() != null ? Math.min(nativeAd.getAdTitle().length(), 21) : 21;
        addView(k.a(context, nativeAd, nativeAdViewAttributes));
    }

    public int getMinVisibleTitleCharacters() {
        return this.f1600b;
    }

    public TextView getTitleTextView() {
        return this.f1599a;
    }
}
