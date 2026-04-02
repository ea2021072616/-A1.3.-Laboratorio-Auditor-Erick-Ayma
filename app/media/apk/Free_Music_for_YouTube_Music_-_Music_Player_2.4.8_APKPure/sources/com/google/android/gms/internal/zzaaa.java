package com.google.android.gms.internal;

import android.content.Context;
@zzzt
/* loaded from: classes.dex */
public final class zzaaa {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzc(Context context, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.zzbv.zzea();
            int zzas = zzahf.zzas(context);
            if (zzas == 0) {
                return false;
            }
            com.google.android.gms.ads.internal.zzbv.zzea();
            return zzas <= zzahf.zzat(context);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzd(Context context, boolean z) {
        return zzc(context, z);
    }
}
