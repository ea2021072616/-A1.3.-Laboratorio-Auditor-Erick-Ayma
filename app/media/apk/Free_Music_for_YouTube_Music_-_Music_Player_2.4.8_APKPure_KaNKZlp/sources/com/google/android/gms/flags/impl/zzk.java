package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzk implements Callable<SharedPreferences> {
    private /* synthetic */ Context zzaok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(Context context) {
        this.zzaok = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() throws Exception {
        return this.zzaok.getSharedPreferences("google_sdk_flags", 0);
    }
}
