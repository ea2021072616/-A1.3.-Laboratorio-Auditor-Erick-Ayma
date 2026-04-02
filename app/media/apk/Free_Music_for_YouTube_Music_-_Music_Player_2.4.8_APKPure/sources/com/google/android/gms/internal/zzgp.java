package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
/* loaded from: classes2.dex */
final class zzgp implements zzgv {
    private /* synthetic */ Activity val$activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgp(zzgn zzgnVar, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.zzgv
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
