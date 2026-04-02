package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
@zzzt
/* loaded from: classes.dex */
public final class zzads extends zzafv implements zzady, zzaeb {
    private final Context mContext;
    private final String zzcbm;
    private final zzafj zzckj;
    private final zzaef zzcvy;
    private final zzaeb zzcvz;
    private final String zzcwa;
    private final zzuk zzcwb;
    private final long zzcwc;
    private zzadv zzcwe;
    private int zzcwd = 0;
    private int mErrorCode = 3;
    private final Object mLock = new Object();

    public zzads(Context context, String str, String str2, zzuk zzukVar, zzafj zzafjVar, zzaef zzaefVar, zzaeb zzaebVar, long j) {
        this.mContext = context;
        this.zzcbm = str;
        this.zzcwa = str2;
        this.zzcwb = zzukVar;
        this.zzckj = zzafjVar;
        this.zzcvy = zzaefVar;
        this.zzcvz = zzaebVar;
        this.zzcwc = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzix zzixVar, zzvd zzvdVar) {
        this.zzcvy.zzpa().zza((zzaeb) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzcbm)) {
                zzvdVar.zza(zzixVar, this.zzcwa, this.zzcwb.zzcaa);
            } else {
                zzvdVar.zzc(zzixVar, this.zzcwa);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Fail to load ad from adapter.", e);
            zza(this.zzcbm, 0);
        }
    }

    private final boolean zzf(long j) {
        long elapsedRealtime = this.zzcwc - (com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            this.mErrorCode = 4;
            return false;
        }
        try {
            this.mLock.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.mErrorCode = 5;
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzaeb
    public final void zza(String str, int i) {
        synchronized (this.mLock) {
            this.zzcwd = 2;
            this.mErrorCode = i;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzaeb
    public final void zzbv(String str) {
        synchronized (this.mLock) {
            this.zzcwd = 1;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        if (this.zzcvy == null || this.zzcvy.zzpa() == null || this.zzcvy.zzoz() == null) {
            return;
        }
        zzaea zzpa = this.zzcvy.zzpa();
        zzpa.zza((zzaeb) null);
        zzpa.zza((zzady) this);
        zzix zzixVar = this.zzckj.zzcrj.zzcnw;
        zzvd zzoz = this.zzcvy.zzoz();
        try {
            if (zzoz.isInitialized()) {
                zzaje.zzdee.post(new zzadt(this, zzixVar, zzoz));
            } else {
                zzaje.zzdee.post(new zzadu(this, zzoz, zzixVar, zzpa));
            }
        } catch (RemoteException e) {
            zzafx.zzc("Fail to check if adapter is initialized.", e);
            zza(this.zzcbm, 0);
        }
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime();
        while (true) {
            synchronized (this.mLock) {
                if (this.zzcwd != 0) {
                    this.zzcwe = new zzadx().zzg(com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime() - elapsedRealtime).zzaa(1 == this.zzcwd ? 6 : this.mErrorCode).zzbw(this.zzcbm).zzbx(this.zzcwb.zzcad).zzox();
                } else if (!zzf(elapsedRealtime)) {
                    this.zzcwe = new zzadx().zzaa(this.mErrorCode).zzg(com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime() - elapsedRealtime).zzbw(this.zzcbm).zzbx(this.zzcwb.zzcad).zzox();
                }
            }
        }
        zzpa.zza((zzaeb) null);
        zzpa.zza((zzady) null);
        if (this.zzcwd == 1) {
            this.zzcvz.zzbv(this.zzcbm);
        } else {
            this.zzcvz.zza(this.zzcbm, this.mErrorCode);
        }
    }

    public final zzadv zzou() {
        zzadv zzadvVar;
        synchronized (this.mLock) {
            zzadvVar = this.zzcwe;
        }
        return zzadvVar;
    }

    public final zzuk zzov() {
        return this.zzcwb;
    }

    @Override // com.google.android.gms.internal.zzady
    public final void zzow() {
        zza(this.zzckj.zzcrj.zzcnw, this.zzcvy.zzoz());
    }

    @Override // com.google.android.gms.internal.zzady
    public final void zzz(int i) {
        zza(this.zzcbm, 0);
    }
}
