package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdy extends zzed {
    private static volatile Long zzajs = null;
    private static final Object zzajk = new Object();

    public zzdy(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 33);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (zzajs == null) {
            synchronized (zzajk) {
                if (zzajs == null) {
                    zzajs = (Long) this.zzajw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajn) {
            this.zzajn.zzdw = zzajs;
        }
    }
}
