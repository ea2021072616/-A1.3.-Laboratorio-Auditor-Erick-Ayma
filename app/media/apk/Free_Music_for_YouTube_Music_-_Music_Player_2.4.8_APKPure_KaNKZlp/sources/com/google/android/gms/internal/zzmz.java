package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
@zzzt
/* loaded from: classes.dex */
public final class zzmz {
    @Nullable
    public static zzmx zza(@Nullable zzmw zzmwVar) {
        if (!zzmwVar.zzin()) {
            zzafx.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzmwVar.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else {
            if (TextUtils.isEmpty(zzmwVar.zzfl())) {
                throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
            }
            return new zzmx(zzmwVar.getContext(), zzmwVar.zzfl(), zzmwVar.zzio(), zzmwVar.zzip());
        }
    }
}
