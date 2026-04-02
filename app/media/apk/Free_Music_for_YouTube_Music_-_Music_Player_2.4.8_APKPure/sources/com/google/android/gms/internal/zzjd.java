package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
@zzzt
/* loaded from: classes.dex */
public final class zzjd extends zzkl {
    private final AppEventListener zzalv;

    public zzjd(AppEventListener appEventListener) {
        this.zzalv = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzalv;
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void onAppEvent(String str, String str2) {
        this.zzalv.onAppEvent(str, str2);
    }
}
