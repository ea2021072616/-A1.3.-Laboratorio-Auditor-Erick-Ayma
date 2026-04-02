package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzdv extends zzed {
    private List<Long> zzajq;

    public zzdv(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 31);
        this.zzajq = null;
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        this.zzajn.zzdu = -1L;
        this.zzajn.zzdv = -1L;
        if (this.zzajq == null) {
            this.zzajq = (List) this.zzajw.invoke(null, this.zzagk.getContext());
        }
        if (this.zzajq == null || this.zzajq.size() != 2) {
            return;
        }
        synchronized (this.zzajn) {
            this.zzajn.zzdu = Long.valueOf(this.zzajq.get(0).longValue());
            this.zzajn.zzdv = Long.valueOf(this.zzajq.get(1).longValue());
        }
    }
}
