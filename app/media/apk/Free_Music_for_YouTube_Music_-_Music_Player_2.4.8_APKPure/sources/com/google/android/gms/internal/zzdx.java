package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdx extends zzed {
    public zzdx(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 51);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzajn) {
            zzdb zzdbVar = new zzdb((String) this.zzajw.invoke(null, new Object[0]));
            this.zzajn.zzej = zzdbVar.zzaic;
            this.zzajn.zzek = zzdbVar.zzaid;
        }
    }
}
