package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
final class zzsm implements Runnable {
    private /* synthetic */ String zzbwj;
    private /* synthetic */ String zzbwk;
    private /* synthetic */ int zzbwl;
    private /* synthetic */ int zzbwm;
    private /* synthetic */ boolean zzbwn = false;
    private /* synthetic */ zzsl zzbwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsm(zzsl zzslVar, String str, String str2, int i, int i2, boolean z) {
        this.zzbwo = zzslVar;
        this.zzbwj = str;
        this.zzbwk = str2;
        this.zzbwl = i;
        this.zzbwm = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzbwj);
        hashMap.put("cachedSrc", this.zzbwk);
        hashMap.put("bytesLoaded", Integer.toString(this.zzbwl));
        hashMap.put("totalBytes", Integer.toString(this.zzbwm));
        hashMap.put("cacheReady", this.zzbwn ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zzbwo.zza("onPrecacheEvent", hashMap);
    }
}
