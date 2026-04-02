package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzoa;
/* loaded from: classes.dex */
final class zzbi implements Runnable {
    private /* synthetic */ zzafi zzaob;
    private /* synthetic */ zzbc zzara;
    private /* synthetic */ String zzarg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbi(zzbc zzbcVar, String str, zzafi zzafiVar) {
        this.zzara = zzbcVar;
        this.zzarg = str;
        this.zzaob = zzafiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzara.zzams.zzaty.get(this.zzarg).zza((zzoa) this.zzaob.zzcyk);
        } catch (RemoteException e) {
            zzafx.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
