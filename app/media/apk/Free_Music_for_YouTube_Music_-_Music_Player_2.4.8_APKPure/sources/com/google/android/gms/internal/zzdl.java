package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdl extends zzed {
    private static volatile String zzajj = null;
    private static final Object zzajk = new Object();

    public zzdl(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 29);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        this.zzajn.zzdt = "E";
        if (zzajj == null) {
            synchronized (zzajk) {
                if (zzajj == null) {
                    zzajj = (String) this.zzajw.invoke(null, this.zzagk.getContext());
                }
            }
        }
        synchronized (this.zzajn) {
            this.zzajn.zzdt = zzbt.zza(zzajj.getBytes(), true);
        }
    }
}
