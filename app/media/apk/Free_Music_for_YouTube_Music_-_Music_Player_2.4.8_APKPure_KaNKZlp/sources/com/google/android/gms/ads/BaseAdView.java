package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzli;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BaseAdView extends ViewGroup {
    protected final zzli zzaky;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzaky = new zzli(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzaky = new zzli(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzaky = new zzli(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzaky.destroy();
    }

    public AdListener getAdListener() {
        return this.zzaky.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzaky.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzaky.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.zzaky.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.zzaky.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzaky.zza(adRequest.zzaz());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        AdSize adSize;
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzaji.zzb("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                i3 = adSize.getWidthInPixels(context);
                i4 = adSize.getHeightInPixels(context);
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zzaky.pause();
    }

    public void resume() {
        this.zzaky.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzaky.setAdListener(adListener);
        if (adListener == null) {
            this.zzaky.zza((zzis) null);
            this.zzaky.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzis) {
            this.zzaky.zza((zzis) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzaky.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzaky.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzaky.setAdUnitId(str);
    }
}
