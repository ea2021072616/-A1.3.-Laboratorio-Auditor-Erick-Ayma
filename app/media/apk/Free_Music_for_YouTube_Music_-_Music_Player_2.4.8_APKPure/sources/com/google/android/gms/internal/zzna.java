package com.google.android.gms.internal;

import android.support.annotation.Nullable;
@zzzt
/* loaded from: classes.dex */
public final class zzna {
    public static boolean zza(@Nullable zznh zznhVar, @Nullable zznf zznfVar, String... strArr) {
        if (zznhVar == null || zznfVar == null) {
            return false;
        }
        return zznhVar.zza(zznfVar, strArr);
    }

    @Nullable
    public static zznf zzb(@Nullable zznh zznhVar) {
        if (zznhVar == null) {
            return null;
        }
        return zznhVar.zziu();
    }
}
