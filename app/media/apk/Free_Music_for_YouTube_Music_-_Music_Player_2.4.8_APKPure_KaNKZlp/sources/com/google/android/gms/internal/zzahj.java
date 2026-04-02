package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahj extends BroadcastReceiver {
    private /* synthetic */ zzahf zzdbv;

    private zzahj(zzahf zzahfVar) {
        this.zzdbv = zzahfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzahj(zzahf zzahfVar, zzahg zzahgVar) {
        this(zzahfVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzdbv.zzdbr = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzdbv.zzdbr = false;
        }
    }
}
