package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzdq extends zzed {
    public zzdq(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        super(zzdcVar, str, str2, zzaxVar, i, 24);
    }

    private final void zzau() {
        AdvertisingIdClient zzao = this.zzagk.zzao();
        if (zzao == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzao.getInfo();
            String zzn = zzdh.zzn(info.getId());
            if (zzn != null) {
                synchronized (this.zzajn) {
                    this.zzajn.zzeu = zzn;
                    this.zzajn.zzew = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.zzajn.zzev = 5;
                }
            }
        } catch (IOException e) {
        }
    }

    @Override // com.google.android.gms.internal.zzed, java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return call();
    }

    @Override // com.google.android.gms.internal.zzed
    protected final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (this.zzagk.zzah()) {
            zzau();
            return;
        }
        synchronized (this.zzajn) {
            this.zzajn.zzeu = (String) this.zzajw.invoke(null, this.zzagk.getApplicationContext());
        }
    }

    @Override // com.google.android.gms.internal.zzed
    public final Void zzat() throws Exception {
        if (this.zzagk.isInitialized()) {
            return super.call();
        }
        if (this.zzagk.zzah()) {
            zzau();
        }
        return null;
    }
}
