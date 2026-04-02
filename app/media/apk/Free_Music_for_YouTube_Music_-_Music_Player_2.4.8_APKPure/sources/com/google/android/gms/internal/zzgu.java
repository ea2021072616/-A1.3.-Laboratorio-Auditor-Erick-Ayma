package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
/* loaded from: classes2.dex */
final class zzgu implements zzgv {
    private /* synthetic */ Activity val$activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgu(zzgn zzgnVar, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzgv
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
    }
}
