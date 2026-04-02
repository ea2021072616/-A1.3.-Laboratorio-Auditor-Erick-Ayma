package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzzt;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzas implements Runnable {
    private boolean zzayh = false;
    private zzaa zzckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzaa zzaaVar) {
        this.zzckd = zzaaVar;
    }

    private final void zzno() {
        zzahf.zzdbo.removeCallbacks(this);
        zzahf.zzdbo.postDelayed(this, 250L);
    }

    public final void pause() {
        this.zzayh = true;
    }

    public final void resume() {
        this.zzayh = false;
        zzno();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzayh) {
            return;
        }
        this.zzckd.zznf();
        zzno();
    }
}
