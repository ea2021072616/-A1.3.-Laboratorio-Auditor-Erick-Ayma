package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
/* loaded from: classes.dex */
final class zzafg implements Runnable {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzajx zzcyb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafg(zzaff zzaffVar, Context context, zzajx zzajxVar) {
        this.zzaok = context;
        this.zzcyb = zzajxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzcyb.set(AdvertisingIdClient.getAdvertisingIdInfo(this.zzaok));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzcyb.setException(e);
            zzaji.zzb("Exception while getting advertising Id info", e);
        }
    }
}
