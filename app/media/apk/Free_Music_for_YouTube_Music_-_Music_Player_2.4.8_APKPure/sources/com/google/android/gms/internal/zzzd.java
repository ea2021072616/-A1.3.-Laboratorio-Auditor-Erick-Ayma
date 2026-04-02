package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
@zzzt
/* loaded from: classes.dex */
public final class zzzd {
    private final Context mContext;
    private final zznh zzamn;
    private final zzcv zzbsr;
    private final zzafj zzckj;
    private final com.google.android.gms.ads.internal.zzbc zzclf;
    private ViewTreeObserver.OnGlobalLayoutListener zzcmu;
    private ViewTreeObserver.OnScrollChangedListener zzcmv;
    private final Object mLock = new Object();
    private int zzaul = -1;
    private int zzaum = -1;
    private zzaix zzaun = new zzaix(200);

    public zzzd(Context context, zzcv zzcvVar, zzafj zzafjVar, zznh zznhVar, com.google.android.gms.ads.internal.zzbc zzbcVar) {
        this.mContext = context;
        this.zzbsr = zzcvVar;
        this.zzckj = zzafjVar;
        this.zzamn = zznhVar;
        this.zzclf = zzbcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener zza(WeakReference<zzakk> weakReference) {
        if (this.zzcmu == null) {
            this.zzcmu = new zzzj(this, weakReference);
        }
        return this.zzcmu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(WeakReference<zzakk> weakReference, boolean z) {
        zzakk zzakkVar;
        if (weakReference == null || (zzakkVar = weakReference.get()) == null) {
            return;
        }
        if (zzakkVar == null) {
            throw null;
        }
        if (((View) zzakkVar) != null) {
            if (!z || this.zzaun.tryAcquire()) {
                if (zzakkVar == null) {
                    throw null;
                }
                int[] iArr = new int[2];
                ((View) zzakkVar).getLocationOnScreen(iArr);
                zzjo.zzhu();
                int zzd = zzaje.zzd(this.mContext, iArr[0]);
                zzjo.zzhu();
                int zzd2 = zzaje.zzd(this.mContext, iArr[1]);
                synchronized (this.mLock) {
                    if (this.zzaul != zzd || this.zzaum != zzd2) {
                        this.zzaul = zzd;
                        this.zzaum = zzd2;
                        zzakkVar.zzsb().zza(this.zzaul, this.zzaum, !z);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeObserver.OnScrollChangedListener zzb(WeakReference<zzakk> weakReference) {
        if (this.zzcmv == null) {
            this.zzcmv = new zzzk(this, weakReference);
        }
        return this.zzcmv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(zzakk zzakkVar) {
        zzakl zzsb = zzakkVar.zzsb();
        zzsb.zza("/video", zzqx.zzbuy);
        zzsb.zza("/videoMeta", zzqx.zzbuz);
        zzsb.zza("/precache", zzqx.zzbvb);
        zzsb.zza("/delayPageLoaded", zzqx.zzbve);
        zzsb.zza("/instrument", zzqx.zzbvc);
        zzsb.zza("/log", zzqx.zzbut);
        zzsb.zza("/videoClicked", zzqx.zzbuu);
        zzsb.zza("/trackActiveViewUnit", new zzzh(this));
        zzsb.zza("/untrackActiveViewUnit", new zzzi(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzakk zzoc() throws zzakw {
        return com.google.android.gms.ads.internal.zzbv.zzeb().zza(this.mContext, zzjb.zzi(this.mContext), false, false, this.zzbsr, this.zzckj.zzcrj.zzatj, this.zzamn, null, this.zzclf.zzbj(), this.zzckj.zzcyo);
    }
}
