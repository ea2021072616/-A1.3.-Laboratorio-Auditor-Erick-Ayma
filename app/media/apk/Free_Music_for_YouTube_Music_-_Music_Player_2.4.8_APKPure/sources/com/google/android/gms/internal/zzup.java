package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzup implements Runnable {
    private /* synthetic */ zzun zzcbw;
    private /* synthetic */ zzuo zzcbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzup(zzuo zzuoVar, zzun zzunVar) {
        this.zzcbx = zzuoVar;
        this.zzcbw = zzunVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i;
        zzvd zzln;
        zzvd zzvdVar;
        boolean zzlo;
        boolean zzu;
        String str;
        obj = this.zzcbx.mLock;
        synchronized (obj) {
            i = this.zzcbx.zzcbu;
            if (i != -2) {
                return;
            }
            zzuo zzuoVar = this.zzcbx;
            zzln = this.zzcbx.zzln();
            zzuoVar.zzcbt = zzln;
            zzvdVar = this.zzcbx.zzcbt;
            if (zzvdVar == null) {
                this.zzcbx.zzt(4);
                return;
            }
            zzlo = this.zzcbx.zzlo();
            if (zzlo) {
                zzu = this.zzcbx.zzu(1);
                if (!zzu) {
                    str = this.zzcbx.zzcbm;
                    zzafx.zzcs(new StringBuilder(String.valueOf(str).length() + 56).append("Ignoring adapter ").append(str).append(" as delayed impression is not supported").toString());
                    this.zzcbx.zzt(2);
                    return;
                }
            }
            this.zzcbw.zza(this.zzcbx);
            this.zzcbx.zza(this.zzcbw);
        }
    }
}
