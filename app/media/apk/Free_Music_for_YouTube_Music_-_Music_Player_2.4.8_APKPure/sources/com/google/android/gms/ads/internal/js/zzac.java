package com.google.android.gms.ads.internal.js;

import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaif;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
/* loaded from: classes.dex */
public final class zzac extends zzakd<zza> {
    private zzaif<zza> zzbyv;
    private final Object mLock = new Object();
    private boolean zzbzn = false;
    private int zzbzo = 0;

    public zzac(zzaif<zza> zzaifVar) {
        this.zzbyv = zzaifVar;
    }

    private final void zzlf() {
        synchronized (this.mLock) {
            zzbp.zzbg(this.zzbzo >= 0);
            if (this.zzbzn && this.zzbzo == 0) {
                zzafx.v("No reference is left (including root). Cleaning up engine.");
                zza(new zzaf(this), new zzakb());
            } else {
                zzafx.v("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzy zzlc() {
        zzy zzyVar = new zzy(this);
        synchronized (this.mLock) {
            zza(new zzad(this, zzyVar), new zzae(this, zzyVar));
            zzbp.zzbg(this.zzbzo >= 0);
            this.zzbzo++;
        }
        return zzyVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzld() {
        synchronized (this.mLock) {
            zzbp.zzbg(this.zzbzo > 0);
            zzafx.v("Releasing 1 reference for JS Engine");
            this.zzbzo--;
            zzlf();
        }
    }

    public final void zzle() {
        synchronized (this.mLock) {
            zzbp.zzbg(this.zzbzo >= 0);
            zzafx.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzbzn = true;
            zzlf();
        }
    }
}
