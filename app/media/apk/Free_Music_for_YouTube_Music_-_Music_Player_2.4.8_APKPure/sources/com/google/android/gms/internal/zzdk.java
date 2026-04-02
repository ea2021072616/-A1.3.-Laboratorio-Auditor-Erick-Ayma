package com.google.android.gms.internal;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdk extends zzed {
    public zzdk(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 49);
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        this.zzajn.zzei = 2;
        try {
            this.zzajn.zzei = Integer.valueOf(((Boolean) this.zzajw.invoke(null, this.zzagk.getApplicationContext())).booleanValue() ? 1 : 0);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
