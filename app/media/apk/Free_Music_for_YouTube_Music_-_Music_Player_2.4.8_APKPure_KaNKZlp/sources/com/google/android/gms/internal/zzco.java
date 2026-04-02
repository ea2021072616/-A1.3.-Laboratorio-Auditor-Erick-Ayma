package com.google.android.gms.internal;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/* loaded from: classes2.dex */
public class zzco {
    private static final ConditionVariable zzagl = new ConditionVariable();
    protected static volatile zzio zzagm = null;
    private static volatile Random zzago = null;
    private zzdc zzagk;
    protected volatile Boolean zzagn;

    public zzco(zzdc zzdcVar) {
        this.zzagk = zzdcVar;
        zzdcVar.zzad().execute(new zzcp(this));
    }

    private static Random zzaa() {
        if (zzago == null) {
            synchronized (zzco.class) {
                if (zzago == null) {
                    zzago = new Random();
                }
            }
        }
        return zzago;
    }

    public static int zzz() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzaa().nextInt();
        } catch (RuntimeException e) {
            return zzaa().nextInt();
        }
    }

    public final void zza(int i, int i2, long j) throws IOException {
        try {
            zzagl.block();
            if (!this.zzagn.booleanValue() || zzagm == null) {
                return;
            }
            zzat zzatVar = new zzat();
            zzatVar.zzch = this.zzagk.zzaie.getPackageName();
            zzatVar.zzci = Long.valueOf(j);
            zziq zzd = zzagm.zzd(zzego.zzc(zzatVar));
            zzd.zzn(i2);
            zzd.zzo(i);
            zzd.zzbe();
        } catch (Exception e) {
        }
    }
}
