package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdu extends zzed {
    private static volatile String zzcy = null;
    private static final Object zzajk = new Object();

    public zzdu(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 1);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        this.zzajn.zzcy = "E";
        if (zzcy == null) {
            synchronized (zzajk) {
                if (zzcy == null) {
                    zzcy = (String) this.zzajw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzajn) {
            this.zzajn.zzcy = zzcy;
        }
    }
}
