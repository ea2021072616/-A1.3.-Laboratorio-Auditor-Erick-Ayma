package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzt
/* loaded from: classes.dex */
public final class zzyk extends zzafv {
    private final Object mLock;
    private final zzyd zzcki;
    private final zzafj zzckj;
    private final zzaao zzckk;
    private final zzys zzckz;
    private Future<zzafi> zzcla;

    public zzyk(Context context, com.google.android.gms.ads.internal.zzbc zzbcVar, zzafj zzafjVar, zzcv zzcvVar, zzyd zzydVar, zznh zznhVar) {
        this(zzafjVar, zzydVar, new zzys(context, zzbcVar, new zzaik(context), zzcvVar, zzafjVar, zznhVar));
    }

    private zzyk(zzafj zzafjVar, zzyd zzydVar, zzys zzysVar) {
        this.mLock = new Object();
        this.zzckj = zzafjVar;
        this.zzckk = zzafjVar.zzcyp;
        this.zzcki = zzydVar;
        this.zzckz = zzysVar;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
        synchronized (this.mLock) {
            if (this.zzcla != null) {
                this.zzcla.cancel(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        zzafi zzafiVar;
        int i = -2;
        try {
            synchronized (this.mLock) {
                this.zzcla = zzagz.zza(zzagz.zzdbh, this.zzckz);
            }
            zzafiVar = this.zzcla.get(60000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            i = 0;
            zzafiVar = null;
        } catch (CancellationException e2) {
            i = 0;
            zzafiVar = null;
        } catch (ExecutionException e3) {
            i = 0;
            zzafiVar = null;
        } catch (TimeoutException e4) {
            zzafx.zzcs("Timed out waiting for native ad.");
            i = 2;
            this.zzcla.cancel(true);
            zzafiVar = null;
        }
        if (zzafiVar == null) {
            zzafiVar = new zzafi(this.zzckj.zzcrj.zzcnw, null, null, i, null, null, this.zzckk.orientation, this.zzckk.zzcba, this.zzckj.zzcrj.zzcnz, false, null, null, null, null, null, this.zzckk.zzcpp, this.zzckj.zzatn, this.zzckk.zzcpn, this.zzckj.zzcyi, this.zzckk.zzcps, this.zzckk.zzcpt, this.zzckj.zzcyc, null, null, null, null, this.zzckj.zzcyp.zzcqg, this.zzckj.zzcyp.zzcqh, null, null, this.zzckk.zzcqk, this.zzckj.zzcyo);
        }
        zzahf.zzdbo.post(new zzyl(this, zzafiVar));
    }
}
