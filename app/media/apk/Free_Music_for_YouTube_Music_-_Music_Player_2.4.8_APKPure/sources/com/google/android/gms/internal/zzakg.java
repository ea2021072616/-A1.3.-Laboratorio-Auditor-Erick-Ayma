package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
@zzzt
/* loaded from: classes.dex */
final class zzakg extends zzaki implements ViewTreeObserver.OnGlobalLayoutListener {
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zzdfk;

    public zzakg(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzdfk = new WeakReference<>(onGlobalLayoutListener);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdfk.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    @Override // com.google.android.gms.internal.zzaki
    protected final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.gms.internal.zzaki
    protected final void zzb(ViewTreeObserver viewTreeObserver) {
        com.google.android.gms.ads.internal.zzbv.zzec().zza(viewTreeObserver, this);
    }
}
