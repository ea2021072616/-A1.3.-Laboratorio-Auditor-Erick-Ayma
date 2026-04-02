package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.exoplayer2.C;
@zzzt
/* loaded from: classes.dex */
public class zzye extends zzxw implements zzakp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzye(Context context, zzafj zzafjVar, zzakk zzakkVar, zzyd zzydVar) {
        super(context, zzafjVar, zzakkVar, zzydVar);
    }

    @Override // com.google.android.gms.internal.zzxw
    protected final void zznr() {
        if (this.zzckk.errorCode != -2) {
            return;
        }
        this.zzbvz.zzsb().zza(this);
        zznt();
        zzafx.zzcb("Loading HTML in WebView.");
        this.zzbvz.loadDataWithBaseURL(this.zzckk.zzchb, this.zzckk.body, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, C.UTF8_NAME, null);
    }

    protected void zznt() {
    }
}
