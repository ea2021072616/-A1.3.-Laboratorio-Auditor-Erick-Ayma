package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzpg;
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzalr;
    private final zzpg zzals;

    public NativeAdView(Context context) {
        super(context);
        this.zzalr = zzc(context);
        this.zzals = zzbg();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzalr = zzc(context);
        this.zzals = zzbg();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzalr = zzc(context);
        this.zzals = zzbg();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzalr = zzc(context);
        this.zzals = zzbg();
    }

    private final zzpg zzbg() {
        zzbp.zzb(this.zzalr, "createDelegate must be called after mOverlayFrame has been created");
        return zzjo.zzhv().zza(this.zzalr.getContext(), this, this.zzalr);
    }

    private final FrameLayout zzc(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzalr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzalr != view) {
            super.bringChildToFront(this.zzalr);
        }
    }

    public void destroy() {
        try {
            this.zzals.destroy();
        } catch (RemoteException e) {
            zzaji.zzb("Unable to destroy native ad view", e);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View zzp = zzp("1098");
        if (zzp instanceof AdChoicesView) {
            return (AdChoicesView) zzp;
        }
        return null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.zzals != null) {
            try {
                this.zzals.zzb(zzn.zzw(view), i);
            } catch (RemoteException e) {
                zzaji.zzb("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzalr);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.zzalr == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza("1098", adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzals.zze((IObjectWrapper) nativeAd.zzbf());
        } catch (RemoteException e) {
            zzaji.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzals.zzd(str, zzn.zzw(view));
        } catch (RemoteException e) {
            zzaji.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View zzp(String str) {
        try {
            IObjectWrapper zzak = this.zzals.zzak(str);
            if (zzak != null) {
                return (View) zzn.zzab(zzak);
            }
        } catch (RemoteException e) {
            zzaji.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }
}
