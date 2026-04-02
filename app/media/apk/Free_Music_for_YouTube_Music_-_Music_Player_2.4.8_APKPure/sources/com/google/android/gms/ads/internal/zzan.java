package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakr;
import com.google.android.gms.internal.zzgi;
/* loaded from: classes.dex */
final class zzan implements zzakr {
    private /* synthetic */ zzafi zzaob;
    private /* synthetic */ zzam zzapu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzam zzamVar, zzafi zzafiVar) {
        this.zzapu = zzamVar;
        this.zzaob = zzafiVar;
    }

    @Override // com.google.android.gms.internal.zzakr
    public final void zzcs() {
        Context context = this.zzapu.zzams.zzaie;
        zzakk zzakkVar = this.zzaob.zzcgz;
        if (zzakkVar == null) {
            throw null;
        }
        new zzgi(context, (View) zzakkVar).zza(this.zzaob.zzcgz);
    }
}
