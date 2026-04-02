package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
@zzzt
/* loaded from: classes.dex */
public final class zzaff implements zzafh {
    @Override // com.google.android.gms.internal.zzafh
    public final zzajr<String> zza(String str, PackageInfo packageInfo) {
        return zzajn.zzg(str);
    }

    @Override // com.google.android.gms.internal.zzafh
    public final zzajr<AdvertisingIdClient.Info> zzac(Context context) {
        zzajx zzajxVar = new zzajx();
        zzjo.zzhu();
        if (zzaje.zzbb(context)) {
            zzagz.zza(new zzafg(this, context, zzajxVar));
        }
        return zzajxVar;
    }
}
