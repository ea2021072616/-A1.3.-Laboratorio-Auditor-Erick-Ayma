package com.google.android.gms.internal;

import com.google.android.exoplayer2.DefaultLoadControl;
/* loaded from: classes2.dex */
public final class zzg implements zzx {
    private int zzn;
    private int zzo;
    private final int zzp;
    private final float zzq;

    public zzg() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1, 1.0f);
    }

    private zzg(int i, int i2, float f) {
        this.zzn = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
        this.zzp = 1;
        this.zzq = 1.0f;
    }

    @Override // com.google.android.gms.internal.zzx
    public final int zza() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.zzx
    public final void zza(zzaa zzaaVar) throws zzaa {
        this.zzo++;
        this.zzn = (int) (this.zzn + (this.zzn * this.zzq));
        if (!(this.zzo <= this.zzp)) {
            throw zzaaVar;
        }
    }

    @Override // com.google.android.gms.internal.zzx
    public final int zzb() {
        return this.zzo;
    }
}
