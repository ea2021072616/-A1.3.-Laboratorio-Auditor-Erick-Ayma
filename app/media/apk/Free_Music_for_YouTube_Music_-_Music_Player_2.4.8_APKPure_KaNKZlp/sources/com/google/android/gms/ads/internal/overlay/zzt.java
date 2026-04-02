package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
final class zzt implements Runnable {
    private /* synthetic */ Drawable zzcgu;
    private /* synthetic */ zzs zzcgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzs zzsVar, Drawable drawable) {
        this.zzcgv = zzsVar;
        this.zzcgu = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        activity = this.zzcgv.zzcgr.mActivity;
        activity.getWindow().setBackgroundDrawable(this.zzcgu);
    }
}
