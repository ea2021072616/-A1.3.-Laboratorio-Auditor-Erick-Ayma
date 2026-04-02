package com.google.android.gms.internal;
@zzzt
/* loaded from: classes.dex */
public final class zzjo {
    private static final Object zzaqm = new Object();
    private static zzjo zzbdj;
    private final zzaje zzbdk = new zzaje();
    private final zzjf zzbdl = new zzjf(new zziw(), new zziv(), new zzlo(), new zzqm(), new zzadn(), new zzxf());

    static {
        zzjo zzjoVar = new zzjo();
        synchronized (zzaqm) {
            zzbdj = zzjoVar;
        }
    }

    protected zzjo() {
    }

    private static zzjo zzht() {
        zzjo zzjoVar;
        synchronized (zzaqm) {
            zzjoVar = zzbdj;
        }
        return zzjoVar;
    }

    public static zzaje zzhu() {
        return zzht().zzbdk;
    }

    public static zzjf zzhv() {
        return zzht().zzbdl;
    }
}
