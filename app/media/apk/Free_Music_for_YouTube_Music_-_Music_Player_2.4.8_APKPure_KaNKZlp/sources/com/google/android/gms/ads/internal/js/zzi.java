package com.google.android.gms.ads.internal.js;

import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.zzakk;
/* loaded from: classes.dex */
final class zzi implements Runnable {
    private /* synthetic */ zze zzbyp;
    private /* synthetic */ String zzbyr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(zze zzeVar, String str) {
        this.zzbyp = zzeVar;
        this.zzbyr = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        zzakkVar = this.zzbyp.zzbvz;
        zzakkVar.loadData(this.zzbyr, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, C.UTF8_NAME);
    }
}
