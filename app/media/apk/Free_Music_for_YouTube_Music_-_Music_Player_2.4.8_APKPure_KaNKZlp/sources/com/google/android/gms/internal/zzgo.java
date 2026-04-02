package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* loaded from: classes2.dex */
final class zzgo implements zzgv {
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ Bundle zzaxl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzgn zzgnVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzaxl = bundle;
    }

    @Override // com.google.android.gms.internal.zzgv
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzaxl);
    }
}
