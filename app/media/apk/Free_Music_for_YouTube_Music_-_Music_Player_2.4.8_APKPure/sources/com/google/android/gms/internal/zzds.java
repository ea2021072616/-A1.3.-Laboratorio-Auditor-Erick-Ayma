package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzds extends zzed {
    private static volatile Long zzajo = null;
    private static final Object zzajk = new Object();

    public zzds(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 22);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (zzajo == null) {
            synchronized (zzajk) {
                if (zzajo == null) {
                    zzajo = (Long) this.zzajw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajn) {
            this.zzajn.zzdr = zzajo;
        }
    }
}
