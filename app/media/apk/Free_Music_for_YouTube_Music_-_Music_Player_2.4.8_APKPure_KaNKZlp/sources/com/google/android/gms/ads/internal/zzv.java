package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzaer;
import com.google.android.gms.internal.zzaew;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzv {
    public final zzsq zzanp;
    public final com.google.android.gms.ads.internal.overlay.zzz zzanq;
    public final zzaew zzanr;
    public final zzio zzans;

    private zzv(zzsq zzsqVar, com.google.android.gms.ads.internal.overlay.zzz zzzVar, zzaew zzaewVar, zzio zzioVar) {
        this.zzanp = zzsqVar;
        this.zzanq = zzzVar;
        this.zzanr = zzaewVar;
        this.zzans = zzioVar;
    }

    public static zzv zzf(Context context) {
        return new zzv(new zzqv(), new com.google.android.gms.ads.internal.overlay.zzad(), new zzaeq(new zzaer()), new zzio(context));
    }
}
