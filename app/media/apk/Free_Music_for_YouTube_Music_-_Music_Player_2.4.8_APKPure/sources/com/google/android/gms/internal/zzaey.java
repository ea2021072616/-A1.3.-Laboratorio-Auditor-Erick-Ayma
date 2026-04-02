package com.google.android.gms.internal;

import android.content.Context;
@zzzt
/* loaded from: classes.dex */
public final class zzaey implements zzgm {
    private final Context mContext;
    private String zzapb;
    private boolean zzcxp = false;
    private final Object mLock = new Object();

    public zzaey(Context context, String str) {
        this.mContext = context;
        this.zzapb = str;
    }

    public final void setAdUnitId(String str) {
        this.zzapb = str;
    }

    @Override // com.google.android.gms.internal.zzgm
    public final void zza(zzgl zzglVar) {
        zzv(zzglVar.zzaxi);
    }

    public final void zzv(boolean z) {
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzr(this.mContext)) {
            synchronized (this.mLock) {
                if (this.zzcxp == z) {
                    return;
                }
                this.zzcxp = z;
                if (this.zzcxp) {
                    com.google.android.gms.ads.internal.zzbv.zzez().zzc(this.mContext, this.zzapb);
                } else {
                    com.google.android.gms.ads.internal.zzbv.zzez().zzd(this.mContext, this.zzapb);
                }
            }
        }
    }
}
