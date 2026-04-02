package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzabx implements Runnable {
    private /* synthetic */ zzaak zzcsg;
    private /* synthetic */ zzaav zzcsh;
    private /* synthetic */ zzabs zzcsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabx(zzabs zzabsVar, zzaak zzaakVar, zzaav zzaavVar) {
        this.zzcsi = zzabsVar;
        this.zzcsg = zzaakVar;
        this.zzcsh = zzaavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaao zzaaoVar;
        try {
            zzaaoVar = this.zzcsi.zzb(this.zzcsg);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AdRequestServiceImpl.loadAdAsync");
            zzafx.zzc("Could not fetch ad response due to an Exception.", e);
            zzaaoVar = null;
        }
        if (zzaaoVar == null) {
            zzaaoVar = new zzaao(0);
        }
        try {
            this.zzcsh.zza(zzaaoVar);
        } catch (RemoteException e2) {
            zzafx.zzc("Fail to forward ad response.", e2);
        }
    }
}
