package com.google.android.gms.internal;

import android.content.Context;
@zzzt
/* loaded from: classes.dex */
public final class zzaeq implements zzaew {
    private zzaex zzcxh;

    public zzaeq(zzaex zzaexVar) {
        this.zzcxh = zzaexVar;
    }

    @Override // com.google.android.gms.internal.zzaew
    public final zzaev zza(Context context, zzajk zzajkVar, zzaao zzaaoVar) {
        if (zzaaoVar.zzcqj == null) {
            return null;
        }
        return new zzaem(context, zzajkVar, zzaaoVar, this.zzcxh);
    }
}
