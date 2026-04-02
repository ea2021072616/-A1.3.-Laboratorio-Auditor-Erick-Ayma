package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzli;
/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {
    private final zzli zzaky;

    public PublisherAdView(Context context) {
        super(context);
        this.zzaky = new zzli(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaky = new zzli(this, attributeSet, true);
        zzbp.zzb(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaky = new zzli(this, attributeSet, true);
    }

    public final void destroy() {
        this.zzaky.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzaky.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzaky.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzaky.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzaky.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzaky.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzaky.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzaky.getOnCustomRenderedAdLoadedListener();
    }

    public final VideoController getVideoController() {
        return this.zzaky.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.zzaky.getVideoOptions();
    }

    public final boolean isLoading() {
        return this.zzaky.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzaky.zza(publisherAdRequest.zzaz());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    protected final void onMeasure(int i, int i2) {
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

    public final void pause() {
        this.zzaky.pause();
    }

    public final void recordManualImpression() {
        this.zzaky.recordManualImpression();
    }

    public final void resume() {
        this.zzaky.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzaky.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzaky.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzaky.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzaky.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzaky.setCorrelator(correlator);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzaky.setManualImpressionsEnabled(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzaky.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzaky.setVideoOptions(videoOptions);
    }

    public final boolean zza(zzkf zzkfVar) {
        return this.zzaky.zza(zzkfVar);
    }
}
