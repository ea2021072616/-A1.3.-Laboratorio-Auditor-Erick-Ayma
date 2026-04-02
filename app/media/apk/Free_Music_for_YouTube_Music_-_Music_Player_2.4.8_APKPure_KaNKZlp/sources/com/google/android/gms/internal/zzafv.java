package com.google.android.gms.internal;

import java.util.concurrent.Future;
@zzzt
/* loaded from: classes.dex */
public abstract class zzafv implements zzahv<Future> {
    private volatile Thread zzdas;
    private final Runnable zzv = new zzafw(this);
    private boolean zzdat = false;

    public zzafv() {
    }

    public zzafv(boolean z) {
    }

    @Override // com.google.android.gms.internal.zzahv
    public final void cancel() {
        onStop();
        if (this.zzdas != null) {
            this.zzdas.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzdc();

    @Override // com.google.android.gms.internal.zzahv
    public final /* synthetic */ Future zzns() {
        return this.zzdat ? zzagz.zza(1, this.zzv) : zzagz.zza(this.zzv);
    }

    public final Future zzqq() {
        return this.zzdat ? zzagz.zza(1, this.zzv) : zzagz.zza(this.zzv);
    }
}
