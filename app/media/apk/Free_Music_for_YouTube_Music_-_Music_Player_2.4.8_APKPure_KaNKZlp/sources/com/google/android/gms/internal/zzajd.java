package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
@zzzt
/* loaded from: classes.dex */
public final class zzajd {
    private final View mView;
    private boolean zzbav;
    private Activity zzddz;
    private boolean zzdea;
    private boolean zzdeb;
    private ViewTreeObserver.OnGlobalLayoutListener zzdec;
    private ViewTreeObserver.OnScrollChangedListener zzded;

    public zzajd(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzddz = activity;
        this.mView = view;
        this.zzdec = onGlobalLayoutListener;
        this.zzded = onScrollChangedListener;
    }

    private final void zzrn() {
        if (this.zzdea) {
            return;
        }
        if (this.zzdec != null) {
            if (this.zzddz != null) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                zzahf.zza(this.zzddz, this.zzdec);
            }
            com.google.android.gms.ads.internal.zzbv.zzey();
            zzakf.zza(this.mView, this.zzdec);
        }
        if (this.zzded != null) {
            if (this.zzddz != null) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                zzahf.zza(this.zzddz, this.zzded);
            }
            com.google.android.gms.ads.internal.zzbv.zzey();
            zzakf.zza(this.mView, this.zzded);
        }
        this.zzdea = true;
    }

    private final void zzro() {
        if (this.zzddz != null && this.zzdea) {
            if (this.zzdec != null && this.zzddz != null) {
                com.google.android.gms.ads.internal.zzbv.zzec().zzb(this.zzddz, this.zzdec);
            }
            if (this.zzded != null && this.zzddz != null) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                zzahf.zzb(this.zzddz, this.zzded);
            }
            this.zzdea = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzdeb = true;
        if (this.zzbav) {
            zzrn();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzdeb = false;
        zzro();
    }

    public final void zzi(Activity activity) {
        this.zzddz = activity;
    }

    public final void zzrl() {
        this.zzbav = true;
        if (this.zzdeb) {
            zzrn();
        }
    }

    public final void zzrm() {
        this.zzbav = false;
        zzro();
    }
}
