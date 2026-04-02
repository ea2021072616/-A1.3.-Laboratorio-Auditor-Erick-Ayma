package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzny;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbh implements Runnable {
    private /* synthetic */ zzny zzann;
    private /* synthetic */ zzbc zzara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(zzbc zzbcVar, zzny zznyVar) {
        this.zzara = zzbcVar;
        this.zzann = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzara.zzams.zzatw != null) {
                this.zzara.zzams.zzatw.zza(this.zzann);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
