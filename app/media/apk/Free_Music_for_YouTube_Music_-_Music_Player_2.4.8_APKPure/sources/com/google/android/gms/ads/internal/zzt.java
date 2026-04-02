package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzny;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzt implements Runnable {
    private /* synthetic */ zzq zzanl;
    private /* synthetic */ zzny zzann;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzq zzqVar, zzny zznyVar) {
        this.zzanl = zzqVar;
        this.zzann = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzanl.zzams.zzatw != null) {
                this.zzanl.zzams.zzatw.zza(this.zzann);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
