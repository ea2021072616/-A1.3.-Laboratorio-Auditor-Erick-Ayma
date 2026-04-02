package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class zzmt<T> implements Callable<T> {
    private /* synthetic */ zzmk zzbfs;
    private /* synthetic */ zzms zzbft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmt(zzms zzmsVar, zzmk zzmkVar) {
        this.zzbft = zzmsVar;
        this.zzbfs = zzmkVar;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        SharedPreferences sharedPreferences;
        zzmk zzmkVar = this.zzbfs;
        sharedPreferences = this.zzbft.zzbfr;
        return (T) zzmkVar.zza(sharedPreferences);
    }
}
