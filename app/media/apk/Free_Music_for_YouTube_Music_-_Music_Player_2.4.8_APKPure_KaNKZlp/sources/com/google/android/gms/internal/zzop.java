package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzop implements zzrn {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzai zzbsy;
    private /* synthetic */ zzom zzbsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(zzom zzomVar, com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        this.zzbsz = zzomVar;
        this.zzbsy = zzaiVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        WeakReference weakReference;
        weakReference = this.zzbsz.zzbsw;
        zzakk zzakkVar2 = (zzakk) weakReference.get();
        if (zzakkVar2 == null) {
            this.zzbsy.zzb("/showOverlay", this);
        } else if (zzakkVar2 == null) {
            throw null;
        } else {
            ((View) zzakkVar2).setVisibility(0);
        }
    }
}
