package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public final class zzbve {
    private static zzbve zzhaq;
    private final zzbuz zzhar = new zzbuz();
    private final zzbva zzhas = new zzbva();

    static {
        zzbve zzbveVar = new zzbve();
        synchronized (zzbve.class) {
            zzhaq = zzbveVar;
        }
    }

    private zzbve() {
    }

    private static zzbve zzapd() {
        zzbve zzbveVar;
        synchronized (zzbve.class) {
            zzbveVar = zzhaq;
        }
        return zzbveVar;
    }

    public static zzbuz zzape() {
        return zzapd().zzhar;
    }

    public static zzbva zzapf() {
        return zzapd().zzhas;
    }
}
