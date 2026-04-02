package com.google.android.gms.internal;

import android.view.View;
/* loaded from: classes2.dex */
public final class zzfq implements zzgw {
    private zzoe zzavz;

    public zzfq(zzoe zzoeVar) {
        this.zzavz = zzoeVar;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final View zzfw() {
        if (this.zzavz != null) {
            return this.zzavz.zzjw();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final boolean zzfx() {
        return this.zzavz == null;
    }

    @Override // com.google.android.gms.internal.zzgw
    public final zzgw zzfy() {
        return this;
    }
}
