package com.google.android.gms.internal;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzzk implements ViewTreeObserver.OnScrollChangedListener {
    private /* synthetic */ zzzd zzcmy;
    private /* synthetic */ WeakReference zzcna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzk(zzzd zzzdVar, WeakReference weakReference) {
        this.zzcmy = zzzdVar;
        this.zzcna = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.zzcmy.zza((WeakReference<zzakk>) this.zzcna, true);
    }
}
