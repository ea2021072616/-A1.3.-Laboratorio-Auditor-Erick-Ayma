package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdn extends zzed {
    public zzdn(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 5);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        this.zzajn.zzdb = -1L;
        this.zzajn.zzdc = -1L;
        int[] iArr = (int[]) this.zzajw.invoke(null, this.zzagk.getContext());
        synchronized (this.zzajn) {
            this.zzajn.zzdb = Long.valueOf(iArr[0]);
            this.zzajn.zzdc = Long.valueOf(iArr[1]);
        }
    }
}
