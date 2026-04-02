package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
@zzzt
/* loaded from: classes.dex */
public final class zzafy extends Handler {
    public zzafy(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AdMobHandler.handleMessage");
        }
    }
}
