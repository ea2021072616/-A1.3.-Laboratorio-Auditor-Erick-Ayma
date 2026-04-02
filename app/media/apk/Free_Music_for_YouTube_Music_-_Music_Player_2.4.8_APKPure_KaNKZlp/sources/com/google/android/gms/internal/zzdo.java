package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdo extends zzed {
    private static volatile Long zzef = null;
    private static final Object zzajk = new Object();

    public zzdo(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 44);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (zzef == null) {
            synchronized (zzajk) {
                if (zzef == null) {
                    zzef = (Long) this.zzajw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajn) {
            this.zzajn.zzef = zzef;
        }
    }
}
