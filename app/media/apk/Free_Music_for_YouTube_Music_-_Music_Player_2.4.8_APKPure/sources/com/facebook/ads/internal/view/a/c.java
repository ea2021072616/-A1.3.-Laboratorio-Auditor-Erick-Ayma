package com.facebook.ads.internal.view.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.util.r;
import com.facebook.ads.internal.util.t;
@TargetApi(19)
/* loaded from: classes.dex */
public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1589a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1590b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f1591c;

    public c(Context context) {
        super(context);
        a();
    }

    private void a() {
        float f = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.f1589a = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f1589a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1589a.setTextSize(2, 20.0f);
        this.f1589a.setEllipsize(TextUtils.TruncateAt.END);
        this.f1589a.setSingleLine(true);
        this.f1589a.setVisibility(8);
        addView(this.f1589a, layoutParams);
        this.f1590b = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f1590b.setAlpha(0.5f);
        this.f1590b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1590b.setTextSize(2, 15.0f);
        this.f1590b.setCompoundDrawablePadding((int) (f * 5.0f));
        this.f1590b.setEllipsize(TextUtils.TruncateAt.END);
        this.f1590b.setSingleLine(true);
        this.f1590b.setVisibility(8);
        addView(this.f1590b, layoutParams2);
    }

    private Drawable getPadlockDrawable() {
        if (this.f1591c == null) {
            this.f1591c = t.b(getContext(), r.BROWSER_PADLOCK);
        }
        return this.f1591c;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1590b.setText((CharSequence) null);
            this.f1590b.setVisibility(8);
            return;
        }
        Uri parse = Uri.parse(str);
        this.f1590b.setText(parse.getHost());
        this.f1590b.setCompoundDrawablesRelativeWithIntrinsicBounds("https".equals(parse.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f1590b.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1589a.setText((CharSequence) null);
            this.f1589a.setVisibility(8);
            return;
        }
        this.f1589a.setText(str);
        this.f1589a.setVisibility(0);
    }
}
