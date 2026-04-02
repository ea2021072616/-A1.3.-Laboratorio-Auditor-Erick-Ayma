package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzso implements Runnable {
    private /* synthetic */ String val$message;
    private /* synthetic */ String zzbwj;
    private /* synthetic */ String zzbwk;
    private /* synthetic */ zzsl zzbwo;
    private /* synthetic */ String zzbwp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzso(zzsl zzslVar, String str, String str2, String str3, String str4) {
        this.zzbwo = zzslVar;
        this.zzbwj = str;
        this.zzbwk = str2;
        this.zzbwp = str3;
        this.val$message = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String zzav;
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zzbwj);
        if (!TextUtils.isEmpty(this.zzbwk)) {
            hashMap.put("cachedSrc", this.zzbwk);
        }
        zzsl zzslVar = this.zzbwo;
        zzav = zzsl.zzav(this.zzbwp);
        hashMap.put("type", zzav);
        hashMap.put("reason", this.zzbwp);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.val$message);
        }
        this.zzbwo.zza("onPrecacheEvent", hashMap);
    }
}
