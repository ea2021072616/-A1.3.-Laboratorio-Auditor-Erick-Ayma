package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class zzfo implements zzgw {
    private WeakReference<zzoe> zzavy;

    public zzfo(zzoe zzoeVar) {
        this.zzavy = new WeakReference<>(zzoeVar);
    }

    @Override // com.google.android.gms.internal.zzgw
    @Nullable
    public final View zzfw() {
        zzoe zzoeVar = this.zzavy.get();
        if (zzoeVar != null) {
            return zzoeVar.zzjw();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final boolean zzfx() {
        return this.zzavy.get() == null;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final zzgw zzfy() {
        return new zzfq(this.zzavy.get());
    }
}
