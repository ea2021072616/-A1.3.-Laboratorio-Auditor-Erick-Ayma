package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public abstract class zzmk<T> {
    private final int zzbfk;
    private final String zzbfl;
    private final T zzbfm;

    private zzmk(int i, String str, T t) {
        this.zzbfk = i;
        this.zzbfl = str;
        this.zzbfm = t;
        com.google.android.gms.ads.internal.zzbv.zzem().zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmk(int i, String str, Object obj, zzml zzmlVar) {
        this(i, str, obj);
    }

    public static zzmk<String> zza(int i, String str) {
        zzmk<String> zza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzbv.zzem().zzb(zza);
        return zza;
    }

    public static zzmk<Float> zza(int i, String str, float f) {
        return new zzmo(i, str, Float.valueOf(0.0f));
    }

    public static zzmk<Integer> zza(int i, String str, int i2) {
        return new zzmm(i, str, Integer.valueOf(i2));
    }

    public static zzmk<Long> zza(int i, String str, long j) {
        return new zzmn(i, str, Long.valueOf(j));
    }

    public static zzmk<Boolean> zza(int i, String str, Boolean bool) {
        return new zzml(i, str, bool);
    }

    public static zzmk<String> zza(int i, String str, String str2) {
        return new zzmp(i, str, str2);
    }

    public static zzmk<String> zzb(int i, String str) {
        zzmk<String> zza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzbv.zzem().zzc(zza);
        return zza;
    }

    public final String getKey() {
        return this.zzbfl;
    }

    public final int getSource() {
        return this.zzbfk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zzb(JSONObject jSONObject);

    public final T zzik() {
        return this.zzbfm;
    }
}
