package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdw extends zzed {
    private final StackTraceElement[] zzajr;

    public zzdw(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzdcVar, str, str2, zzaxVar, i, 45);
        this.zzajr = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (this.zzajr != null) {
            zzda zzdaVar = new zzda((String) this.zzajw.invoke(null, this.zzajr));
            synchronized (this.zzajn) {
                this.zzajn.zzeg = zzdaVar.zzahz;
                if (zzdaVar.zzaia.booleanValue()) {
                    this.zzajn.zzeo = Integer.valueOf(zzdaVar.zzaib.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
