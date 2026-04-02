package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
/* loaded from: classes2.dex */
public final class zzfr implements zzgw {
    @Nullable
    private final View mView;
    @Nullable
    private final zzafi zzawa;

    public zzfr(View view, zzafi zzafiVar) {
        this.mView = view;
        this.zzawa = zzafiVar;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final View zzfw() {
        return this.mView;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final boolean zzfx() {
        return this.zzawa == null || this.mView == null;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final zzgw zzfy() {
        return this;
    }
}
