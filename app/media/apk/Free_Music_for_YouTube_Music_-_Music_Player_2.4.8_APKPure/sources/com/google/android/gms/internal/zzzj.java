package com.google.android.gms.internal;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzzj implements ViewTreeObserver.OnGlobalLayoutListener {
    private /* synthetic */ zzzd zzcmy;
    private /* synthetic */ WeakReference zzcna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzj(zzzd zzzdVar, WeakReference weakReference) {
        this.zzcmy = zzzdVar;
        this.zzcna = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.zzcmy.zza((WeakReference<zzakk>) this.zzcna, false);
    }
}
