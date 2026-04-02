package com.facebook.ads.internal.view.b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.k;
import com.facebook.ads.internal.view.o;
/* loaded from: classes.dex */
public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1601a;

    /* renamed from: b  reason: collision with root package name */
    private a f1602b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1603c;
    private LinearLayout d;

    public b(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes, boolean z, int i) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setVerticalGravity(16);
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        this.d = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        this.d.setOrientation(0);
        this.d.setGravity(16);
        layoutParams2.weight = 3.0f;
        this.d.setLayoutParams(layoutParams2);
        linearLayout.addView(this.d);
        this.f1601a = new c(getContext());
        int a2 = a(z, i);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Math.round(a2 * displayMetrics.density), Math.round(a2 * displayMetrics.density));
        layoutParams3.setMargins(0, 0, Math.round(15.0f * displayMetrics.density), 0);
        this.f1601a.setLayoutParams(layoutParams3);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), this.f1601a);
        this.d.addView(this.f1601a);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        this.d.addView(linearLayout2);
        this.f1602b = new a(getContext(), nativeAd, nativeAdViewAttributes);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.setMargins(0, 0, Math.round(15.0f * displayMetrics.density), 0);
        layoutParams4.weight = 0.5f;
        this.f1602b.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.f1602b);
        this.f1603c = new TextView(getContext());
        this.f1603c.setPadding(Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density));
        this.f1603c.setText(nativeAd.getAdCallToAction());
        this.f1603c.setTextColor(nativeAdViewAttributes.getButtonTextColor());
        this.f1603c.setTextSize(14.0f);
        this.f1603c.setTypeface(nativeAdViewAttributes.getTypeface(), 1);
        this.f1603c.setMaxLines(2);
        this.f1603c.setEllipsize(TextUtils.TruncateAt.END);
        this.f1603c.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(nativeAdViewAttributes.getButtonColor());
        gradientDrawable.setCornerRadius(displayMetrics.density * 5.0f);
        gradientDrawable.setStroke(1, nativeAdViewAttributes.getButtonBorderColor());
        this.f1603c.setBackgroundDrawable(gradientDrawable);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.weight = 0.25f;
        this.f1603c.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.f1603c);
        if (z) {
            o oVar = new o(getContext());
            oVar.setText(nativeAd.getAdBody());
            k.b(oVar, nativeAdViewAttributes);
            oVar.setMinTextSize(nativeAdViewAttributes.getDescriptionTextSize() - 1);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams6.weight = 1.0f;
            oVar.setLayoutParams(layoutParams6);
            oVar.setGravity(80);
            linearLayout.addView(oVar);
        }
    }

    private int a(boolean z, int i) {
        return (int) ((i - 30) * (3.0d / ((z ? 1 : 0) + 3)));
    }

    public TextView getCallToActionView() {
        return this.f1603c;
    }

    public ImageView getIconView() {
        return this.f1601a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        TextView titleTextView = this.f1602b.getTitleTextView();
        if (titleTextView.getLayout().getLineEnd(titleTextView.getLineCount() - 1) < this.f1602b.getMinVisibleTitleCharacters()) {
            this.d.removeView(this.f1601a);
            super.onMeasure(i, i2);
        }
    }
}
