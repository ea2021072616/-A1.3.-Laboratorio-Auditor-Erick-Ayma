package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzacx extends zzadf {
    private final Context mContext;
    private final Object mLock;
    private final zzajk zzapc;
    private final zzacy zzcvq;

    public zzacx(Context context, com.google.android.gms.ads.internal.zzv zzvVar, zzva zzvaVar, zzajk zzajkVar) {
        this(context, zzajkVar, new zzacy(context, zzvVar, zzjb.zzhm(), zzvaVar, zzajkVar));
    }

    private zzacx(Context context, zzajk zzajkVar, zzacy zzacyVar) {
        this.mLock = new Object();
        this.mContext = context;
        this.zzapc = zzajkVar;
        this.zzcvq = zzacyVar;
    }

    @Override // com.google.android.gms.internal.zzade
    public final void destroy() {
        zzh(null);
    }

    @Override // com.google.android.gms.internal.zzade
    public final String getMediationAdapterClassName() {
        String mediationAdapterClassName;
        synchronized (this.mLock) {
            mediationAdapterClassName = this.zzcvq.getMediationAdapterClassName();
        }
        return mediationAdapterClassName;
    }

    @Override // com.google.android.gms.internal.zzade
    public final boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.mLock) {
            isLoaded = this.zzcvq.isLoaded();
        }
        return isLoaded;
    }

    @Override // com.google.android.gms.internal.zzade
    public final void pause() {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void resume() {
        zzg(null);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            this.zzcvq.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.internal.zzade
    public final void setUserId(String str) {
        zzafx.zzcs("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    @Override // com.google.android.gms.internal.zzade
    public final void show() {
        synchronized (this.mLock) {
            this.zzcvq.zzos();
        }
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zza(zzadj zzadjVar) {
        synchronized (this.mLock) {
            this.zzcvq.zza(zzadjVar);
        }
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zza(zzadp zzadpVar) {
        synchronized (this.mLock) {
            this.zzcvq.zza(zzadpVar);
        }
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzf(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzcvq.pause();
        }
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzg(IObjectWrapper iObjectWrapper) {
        Context context;
        synchronized (this.mLock) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                try {
                    context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
                } catch (Exception e) {
                    zzafx.zzc("Unable to extract updated context.", e);
                }
            }
            if (context != null) {
                this.zzcvq.onContextChanged(context);
            }
            this.zzcvq.resume();
        }
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzh(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzcvq.destroy();
        }
    }
}
