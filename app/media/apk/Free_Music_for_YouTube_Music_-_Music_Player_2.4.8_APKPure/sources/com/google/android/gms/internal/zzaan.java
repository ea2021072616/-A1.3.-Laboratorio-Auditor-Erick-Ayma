package com.google.android.gms.internal;

import java.lang.ref.WeakReference;
@zzzt
/* loaded from: classes.dex */
public final class zzaan extends zzaaw {
    private final WeakReference<zzaac> zzcpm;

    public zzaan(zzaac zzaacVar) {
        this.zzcpm = new WeakReference<>(zzaacVar);
    }

    @Override // com.google.android.gms.internal.zzaav
    public final void zza(zzaao zzaaoVar) {
        zzaac zzaacVar = this.zzcpm.get();
        if (zzaacVar != null) {
            zzaacVar.zza(zzaaoVar);
        }
    }
}
