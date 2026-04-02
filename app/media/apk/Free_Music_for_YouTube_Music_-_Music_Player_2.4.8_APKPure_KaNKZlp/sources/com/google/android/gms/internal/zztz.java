package com.google.android.gms.internal;

import android.os.Bundle;
@zzzt
/* loaded from: classes.dex */
public final class zztz {
    private static zztz zzbxv = new zztz();
    private int zzbxw;
    private int zzbxx;
    private int zzbxy;
    private int zzbxz;
    private int zzbya;

    public static zztz zzkp() {
        return zzbxv;
    }

    public final Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.zzbxw);
        bundle.putInt("ipds", this.zzbxx);
        bundle.putInt("ipde", this.zzbxy);
        bundle.putInt("iph", this.zzbxz);
        bundle.putInt("ipm", this.zzbya);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzkq() {
        this.zzbxx++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzkr() {
        this.zzbxy++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzks() {
        this.zzbxz++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzkt() {
        this.zzbya++;
    }

    public final int zzku() {
        return this.zzbxx;
    }

    public final int zzkv() {
        return this.zzbxy;
    }

    public final int zzkw() {
        return this.zzbxz;
    }

    public final int zzkx() {
        return this.zzbya;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzs(int i) {
        this.zzbxw += i;
    }
}
