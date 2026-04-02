package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzgk extends BroadcastReceiver {
    private /* synthetic */ zzgi zzaww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzgi zzgiVar) {
        this.zzaww = zzgiVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzaww.zzk(3);
    }
}
