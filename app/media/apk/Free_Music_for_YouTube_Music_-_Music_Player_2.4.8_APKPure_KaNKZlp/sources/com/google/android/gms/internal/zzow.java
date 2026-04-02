package com.google.android.gms.internal;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
final class zzow implements Runnable {
    private /* synthetic */ zzoi zzbtp;
    private /* synthetic */ zzov zzbtq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzow(zzov zzovVar, zzoi zzoiVar) {
        this.zzbtq = zzovVar;
        this.zzbtp = zzoiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        try {
            zzakkVar = this.zzbtp.zzju();
        } catch (Exception e) {
            zzafx.zzb("Error obtaining overlay.", e);
            zzakkVar = null;
        }
        if (zzakkVar != null && this.zzbtq.zzalr != null) {
            FrameLayout frameLayout = this.zzbtq.zzalr;
            if (zzakkVar == null) {
                throw null;
            }
            frameLayout.addView((View) zzakkVar);
        }
        if (this.zzbtp instanceof zzod) {
            return;
        }
        this.zzbtq.zza(this.zzbtp);
    }
}
