package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdt extends zzed {
    private long zzajp;

    public zzdt(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 12);
        this.zzajp = -1L;
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblr)).booleanValue()) {
            this.zzajn.zzdi = -1L;
            this.zzajn.zzdi = (Long) this.zzajw.invoke(null, this.zzagk.getContext());
            return;
        }
        this.zzajn.zzdi = -1L;
        if (this.zzajp == -1) {
            this.zzajp = ((Long) this.zzajw.invoke(null, this.zzagk.getContext())).longValue();
        }
        synchronized (this.zzajn) {
            this.zzajn.zzdi = Long.valueOf(this.zzajp);
        }
    }
}
