package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zze implements Callable<Integer> {
    private /* synthetic */ SharedPreferences zzhat;
    private /* synthetic */ String zzhau;
    private /* synthetic */ Integer zzhaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(SharedPreferences sharedPreferences, String str, Integer num) {
        this.zzhat = sharedPreferences;
        this.zzhau = str;
        this.zzhaw = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        return Integer.valueOf(this.zzhat.getInt(this.zzhau, this.zzhaw.intValue()));
    }
}
