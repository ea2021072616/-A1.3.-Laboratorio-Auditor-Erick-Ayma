package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdz extends zzed {
    public zzdz(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 48);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        this.zzajn.zzeh = 2;
        boolean booleanValue = ((Boolean) this.zzajw.invoke(null, this.zzagk.getApplicationContext())).booleanValue();
        synchronized (this.zzajn) {
            if (booleanValue) {
                this.zzajn.zzeh = 1;
            } else {
                this.zzajn.zzeh = 0;
            }
        }
    }
}
