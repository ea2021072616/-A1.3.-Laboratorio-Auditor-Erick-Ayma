package com.google.android.gms.ads.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzzt;
import java.lang.ref.WeakReference;
@zzzt
/* loaded from: classes.dex */
public final class zzbl {
    private final zzbn zzarh;
    @Nullable
    private zzix zzari;
    private boolean zzarj;
    private boolean zzark;
    private long zzarl;
    private final Runnable zzv;

    public zzbl(zza zzaVar) {
        this(zzaVar, new zzbn(zzahf.zzdbo));
    }

    private zzbl(zza zzaVar, zzbn zzbnVar) {
        this.zzarj = false;
        this.zzark = false;
        this.zzarl = 0L;
        this.zzarh = zzbnVar;
        this.zzv = new zzbm(this, new WeakReference(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zza(zzbl zzblVar, boolean z) {
        zzblVar.zzarj = false;
        return false;
    }

    public final void cancel() {
        this.zzarj = false;
        this.zzarh.removeCallbacks(this.zzv);
    }

    public final void pause() {
        this.zzark = true;
        if (this.zzarj) {
            this.zzarh.removeCallbacks(this.zzv);
        }
    }

    public final void resume() {
        this.zzark = false;
        if (this.zzarj) {
            this.zzarj = false;
            zza(this.zzari, this.zzarl);
        }
    }

    public final void zza(zzix zzixVar, long j) {
        if (this.zzarj) {
            zzafx.zzcs("An ad refresh is already scheduled.");
            return;
        }
        this.zzari = zzixVar;
        this.zzarj = true;
        this.zzarl = j;
        if (this.zzark) {
            return;
        }
        zzafx.zzcr(new StringBuilder(65).append("Scheduling ad refresh ").append(j).append(" milliseconds from now.").toString());
        this.zzarh.postDelayed(this.zzv, j);
    }

    public final boolean zzdp() {
        return this.zzarj;
    }

    public final void zzf(zzix zzixVar) {
        this.zzari = zzixVar;
    }

    public final void zzg(zzix zzixVar) {
        zza(zzixVar, 60000L);
    }
}
