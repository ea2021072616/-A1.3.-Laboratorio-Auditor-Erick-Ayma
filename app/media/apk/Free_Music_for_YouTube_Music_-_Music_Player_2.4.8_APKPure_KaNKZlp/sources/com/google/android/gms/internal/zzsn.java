package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzsn implements Runnable {
    private /* synthetic */ String zzbwj;
    private /* synthetic */ String zzbwk;
    private /* synthetic */ int zzbwm;
    private /* synthetic */ zzsl zzbwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsn(zzsl zzslVar, String str, String str2, int i) {
        this.zzbwo = zzslVar;
        this.zzbwj = str;
        this.zzbwk = str2;
        this.zzbwm = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzbwj);
        hashMap.put("cachedSrc", this.zzbwk);
        hashMap.put("totalBytes", Integer.toString(this.zzbwm));
        this.zzbwo.zza("onPrecacheEvent", hashMap);
    }
}
