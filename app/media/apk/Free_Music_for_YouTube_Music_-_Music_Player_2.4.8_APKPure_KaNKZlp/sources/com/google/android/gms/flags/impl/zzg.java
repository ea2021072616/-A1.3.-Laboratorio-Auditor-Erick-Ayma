package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzg implements Callable<Long> {
    private /* synthetic */ SharedPreferences zzhat;
    private /* synthetic */ String zzhau;
    private /* synthetic */ Long zzhax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(SharedPreferences sharedPreferences, String str, Long l) {
        this.zzhat = sharedPreferences;
        this.zzhau = str;
        this.zzhax = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.zzhat.getLong(this.zzhau, this.zzhax.longValue()));
    }
}
