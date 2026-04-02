package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahh implements Runnable {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzahf zzdbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahh(zzahf zzahfVar, Context context) {
        this.zzdbv = zzahfVar;
        this.zzaok = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.zzdbv.mLock;
        synchronized (obj) {
            this.zzdbv.zzbwh = zzahf.zzai(this.zzaok);
            obj2 = this.zzdbv.mLock;
            obj2.notifyAll();
        }
    }
}
