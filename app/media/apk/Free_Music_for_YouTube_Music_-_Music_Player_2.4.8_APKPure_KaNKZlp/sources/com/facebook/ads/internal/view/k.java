package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
/* loaded from: classes.dex */
public abstract class k {
    public static LinearLayout a(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        LinearLayout linearLayout = new LinearLayout(context);
        o oVar = new o(context);
        oVar.setText(nativeAd.getAdSocialContext());
        b(oVar, nativeAdViewAttributes);
        linearLayout.addView(oVar);
        return linearLayout;
    }

    public static void a(TextView textView, NativeAdViewAttributes nativeAdViewAttributes) {
        textView.setTextColor(nativeAdViewAttributes.getTitleTextColor());
        textView.setTextSize(nativeAdViewAttributes.getTitleTextSize());
        textView.setTypeface(nativeAdViewAttributes.getTypeface(), 1);
    }

    public static void b(TextView textView, NativeAdViewAttributes nativeAdViewAttributes) {
        textView.setTextColor(nativeAdViewAttributes.getDescriptionTextColor());
        textView.setTextSize(nativeAdViewAttributes.getDescriptionTextSize());
        textView.setTypeface(nativeAdViewAttributes.getTypeface());
    }
}
