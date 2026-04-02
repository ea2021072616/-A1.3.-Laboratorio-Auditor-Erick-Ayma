package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzagz;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzcq;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
@zzzt
/* loaded from: classes.dex */
public final class zzah implements zzcq, Runnable {
    private Context zzaie;
    private final List<Object[]> zzaom;
    private final AtomicReference<zzcq> zzaon;
    private zzajk zzaoo;
    private CountDownLatch zzaop;

    private zzah(Context context, zzajk zzajkVar) {
        this.zzaom = new Vector();
        this.zzaon = new AtomicReference<>();
        this.zzaop = new CountDownLatch(1);
        this.zzaie = context;
        this.zzaoo = zzajkVar;
        zzjo.zzhu();
        if (zzaje.zzrq()) {
            zzagz.zza(this);
        } else {
            run();
        }
    }

    public zzah(zzbw zzbwVar) {
        this(zzbwVar.zzaie, zzbwVar.zzatj);
    }

    private final boolean zzct() {
        try {
            this.zzaop.await();
            return true;
        } catch (InterruptedException e) {
            zzafx.zzc("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzcu() {
        if (this.zzaom.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.zzaom) {
            if (objArr.length == 1) {
                this.zzaon.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.zzaon.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzaom.clear();
    }

    private static Context zzg(Context context) {
        Context applicationContext;
        return (((Boolean) zzbv.zzen().zzd(zzmu.zzbgg)).booleanValue() && (applicationContext = context.getApplicationContext()) != null) ? applicationContext : context;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context, com.google.android.gms.internal.zzajk] */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzaon.set(zzcu.zza(this.zzaoo.zzcp, zzg(this.zzaie), !((Boolean) zzbv.zzen().zzd(zzmu.zzbjq)).booleanValue() && (this.zzaoo.zzden)));
        } finally {
            this.zzaop.countDown();
            this.zzaie = null;
            this.zzaoo = null;
        }
    }

    @Override // com.google.android.gms.internal.zzcq
    public final String zza(Context context) {
        zzcq zzcqVar;
        if (!zzct() || (zzcqVar = this.zzaon.get()) == null) {
            return "";
        }
        zzcu();
        return zzcqVar.zza(zzg(context));
    }

    @Override // com.google.android.gms.internal.zzcq
    public final String zza(Context context, String str, View view) {
        zzcq zzcqVar;
        if (!zzct() || (zzcqVar = this.zzaon.get()) == null) {
            return "";
        }
        zzcu();
        return zzcqVar.zza(zzg(context), str, view);
    }

    @Override // com.google.android.gms.internal.zzcq
    public final void zza(int i, int i2, int i3) {
        zzcq zzcqVar = this.zzaon.get();
        if (zzcqVar == null) {
            this.zzaom.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        zzcu();
        zzcqVar.zza(i, i2, i3);
    }

    @Override // com.google.android.gms.internal.zzcq
    public final void zza(MotionEvent motionEvent) {
        zzcq zzcqVar = this.zzaon.get();
        if (zzcqVar == null) {
            this.zzaom.add(new Object[]{motionEvent});
            return;
        }
        zzcu();
        zzcqVar.zza(motionEvent);
    }
}
