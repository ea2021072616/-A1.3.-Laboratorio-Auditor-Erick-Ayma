package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
@zzzt
/* loaded from: classes.dex */
final class zzakh extends zzaki implements ViewTreeObserver.OnScrollChangedListener {
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> zzdfk;

    public zzakh(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.zzdfk = new WeakReference<>(onScrollChangedListener);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zzdfk.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            detach();
        }
    }

    @Override // com.google.android.gms.internal.zzaki
    protected final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    @Override // com.google.android.gms.internal.zzaki
    protected final void zzb(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
