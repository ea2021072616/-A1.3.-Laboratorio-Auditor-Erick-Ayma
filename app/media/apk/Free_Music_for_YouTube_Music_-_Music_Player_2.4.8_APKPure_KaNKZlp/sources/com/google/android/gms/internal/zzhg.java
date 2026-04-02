package com.google.android.gms.internal;

import android.webkit.ValueCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzhg implements ValueCallback<String> {
    private /* synthetic */ zzhf zzaze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhg(zzhf zzhfVar) {
        this.zzaze = zzhfVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.zzaze.zzayz.zza(this.zzaze.zzazb, this.zzaze.zzazc, str, this.zzaze.zzazd);
    }
}
