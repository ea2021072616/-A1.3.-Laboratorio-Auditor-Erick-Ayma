package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;
/* loaded from: classes2.dex */
final class zzfp extends ContentObserver {
    private /* synthetic */ zzfm zzavx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfp(zzfm zzfmVar, Handler handler) {
        super(handler);
        this.zzavx = zzfmVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        this.zzavx.zzfq();
    }
}
