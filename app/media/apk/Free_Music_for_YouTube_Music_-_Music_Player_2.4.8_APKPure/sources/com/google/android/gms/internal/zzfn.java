package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
final class zzfn extends BroadcastReceiver {
    private /* synthetic */ zzfm zzavx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfn(zzfm zzfmVar) {
        this.zzavx = zzfmVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzavx.zzj(3);
    }
}
