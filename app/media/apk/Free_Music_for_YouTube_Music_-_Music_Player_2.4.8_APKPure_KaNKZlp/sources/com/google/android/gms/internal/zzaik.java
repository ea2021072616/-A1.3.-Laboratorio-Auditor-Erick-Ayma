package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzaik {
    private static zzs zzdda;
    private static final Object zzddb = new Object();
    private static zzaio<Void> zzddc = new zzail();

    public zzaik(Context context) {
        zzax(context);
    }

    private static zzs zzax(Context context) {
        zzs zzsVar;
        synchronized (zzddb) {
            if (zzdda == null) {
                zzdda = zzas.zza(context.getApplicationContext(), null);
            }
            zzsVar = zzdda;
        }
        return zzsVar;
    }

    public final zzajr<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        zzait zzaitVar = new zzait(this, null);
        zzdda.zzc(new zzain(this, i, str, zzaitVar, new zzaim(this, str, zzaitVar), bArr, map));
        return zzaitVar;
    }

    public final <T> zzajr<T> zza(String str, zzaio<T> zzaioVar) {
        zzait zzaitVar = new zzait(this, null);
        zzdda.zzc(new zzaip(str, zzaioVar, zzaitVar));
        return zzaitVar;
    }

    public final zzajr<String> zzb(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
