package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
@zzzt
/* loaded from: classes.dex */
final class zzafl {
    private long zzcyz = -1;
    private long zzcza = -1;

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzcyz);
        bundle.putLong("tclose", this.zzcza);
        return bundle;
    }

    public final long zzpi() {
        return this.zzcza;
    }

    public final void zzpj() {
        this.zzcza = SystemClock.elapsedRealtime();
    }

    public final void zzpk() {
        this.zzcyz = SystemClock.elapsedRealtime();
    }
}
