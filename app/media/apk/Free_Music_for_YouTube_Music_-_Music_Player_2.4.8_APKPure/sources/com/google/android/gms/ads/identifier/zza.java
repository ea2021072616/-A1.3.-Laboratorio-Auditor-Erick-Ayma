package com.google.android.gms.ads.identifier;

import java.util.Map;
/* loaded from: classes.dex */
final class zza extends Thread {
    private /* synthetic */ Map zzamc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzamc = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zze().zzb(this.zzamc);
    }
}
