package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.exoplayer2.C;
import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzon implements zzrn {
    final /* synthetic */ com.google.android.gms.ads.internal.js.zzai zzbsy;
    final /* synthetic */ zzom zzbsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(zzom zzomVar, com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        this.zzbsz = zzomVar;
        this.zzbsy = zzaiVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        WeakReference weakReference;
        weakReference = this.zzbsz.zzbsw;
        zzakk zzakkVar2 = (zzakk) weakReference.get();
        if (zzakkVar2 == null) {
            this.zzbsy.zzb("/loadHtml", this);
            return;
        }
        zzakkVar2.zzsb().zza(new zzoo(this, map));
        String str = map.get("overlayHtml");
        String str2 = map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzakkVar2.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, C.UTF8_NAME);
        } else {
            zzakkVar2.loadDataWithBaseURL(str2, str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, C.UTF8_NAME, null);
        }
    }
}
