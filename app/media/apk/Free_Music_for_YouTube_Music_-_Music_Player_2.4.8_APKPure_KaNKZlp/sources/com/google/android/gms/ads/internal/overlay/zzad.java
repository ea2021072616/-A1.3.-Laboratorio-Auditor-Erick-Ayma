package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzad extends zzz {
    @Override // com.google.android.gms.ads.internal.overlay.zzz
    @Nullable
    public final zzy zza(Context context, zzakk zzakkVar, int i, boolean z, zznh zznhVar, zzaq zzaqVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            return new zzd(context, z, zzakkVar.zzbl().zzbcr, zzaqVar, new zzar(context, zzakkVar.zzse(), zzakkVar.getRequestId(), zznhVar, zzakkVar.zzsk()));
        }
        return null;
    }
}
