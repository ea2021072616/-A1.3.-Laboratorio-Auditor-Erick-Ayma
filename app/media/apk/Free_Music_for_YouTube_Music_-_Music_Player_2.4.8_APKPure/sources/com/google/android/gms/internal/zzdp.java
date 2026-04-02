package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdp extends zzed {
    private long startTime;

    public zzdp(zzdc zzdcVar, String str, String str2, zzax zzaxVar, long j, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzajw.invoke(null, new Object[0])).longValue();
        synchronized (this.zzajn) {
            this.zzajn.zzey = Long.valueOf(longValue);
            if (this.startTime != 0) {
                this.zzajn.zzdn = Long.valueOf(longValue - this.startTime);
                this.zzajn.zzds = Long.valueOf(this.startTime);
            }
        }
    }
}
