package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class zzfs implements zzgw {
    private final WeakReference<View> zzawb;
    private final WeakReference<zzafi> zzawc;

    public zzfs(View view, zzafi zzafiVar) {
        this.zzawb = new WeakReference<>(view);
        this.zzawc = new WeakReference<>(zzafiVar);
    }

    @Override // com.google.android.gms.internal.zzgw
    public final View zzfw() {
        return this.zzawb.get();
    }

    @Override // com.google.android.gms.internal.zzgw
    public final boolean zzfx() {
        return this.zzawb.get() == null || this.zzawc.get() == null;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final zzgw zzfy() {
        return new zzfr(this.zzawb.get(), this.zzawc.get());
    }
}
