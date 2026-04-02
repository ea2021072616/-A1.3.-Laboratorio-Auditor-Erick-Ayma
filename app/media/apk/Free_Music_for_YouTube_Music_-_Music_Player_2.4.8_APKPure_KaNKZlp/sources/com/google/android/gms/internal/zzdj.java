package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdj extends zzed {
    public zzdj(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 3);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzajn) {
            this.zzajn.zzcz = -1L;
            this.zzajn.zzcz = (Long) this.zzajw.invoke(null, this.zzagk.getContext());
        }
    }
}
