package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.DownloadManager;
@TargetApi(9)
/* loaded from: classes.dex */
public class zzahm extends zzahk {
    public zzahm() {
        super();
    }

    @Override // com.google.android.gms.internal.zzahk
    public boolean zza(DownloadManager.Request request) {
        request.setShowRunningNotification(true);
        return true;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final int zzqy() {
        return 6;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final int zzqz() {
        return 7;
    }
}
