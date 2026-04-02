package com.google.android.gms.internal;

import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public final class zzdr implements Callable {
    private final zzdc zzagk;
    private final zzax zzajn;

    public zzdr(zzdc zzdcVar, zzax zzaxVar) {
        this.zzagk = zzdcVar;
        this.zzajn = zzaxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzat */
    public final Void call() throws Exception {
        if (this.zzagk.zzal() != null) {
            this.zzagk.zzal().get();
        }
        zzax zzak = this.zzagk.zzak();
        if (zzak != null) {
            try {
                synchronized (this.zzajn) {
                    zzego.zza(this.zzajn, zzego.zzc(zzak));
                }
                return null;
            } catch (zzegn e) {
                return null;
            }
        }
        return null;
    }
}
