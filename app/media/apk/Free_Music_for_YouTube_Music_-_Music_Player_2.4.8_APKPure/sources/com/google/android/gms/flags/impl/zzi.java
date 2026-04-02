package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzi implements Callable<String> {
    private /* synthetic */ SharedPreferences zzhat;
    private /* synthetic */ String zzhau;
    private /* synthetic */ String zzhay;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(SharedPreferences sharedPreferences, String str, String str2) {
        this.zzhat = sharedPreferences;
        this.zzhau = str;
        this.zzhay = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.zzhat.getString(this.zzhau, this.zzhay);
    }
}
