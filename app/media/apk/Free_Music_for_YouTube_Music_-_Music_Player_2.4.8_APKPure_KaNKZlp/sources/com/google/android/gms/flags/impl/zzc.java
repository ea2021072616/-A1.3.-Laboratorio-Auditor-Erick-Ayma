package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzc implements Callable<Boolean> {
    private /* synthetic */ SharedPreferences zzhat;
    private /* synthetic */ String zzhau;
    private /* synthetic */ Boolean zzhav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.zzhat = sharedPreferences;
        this.zzhau = str;
        this.zzhav = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.zzhat.getBoolean(this.zzhau, this.zzhav.booleanValue()));
    }
}
