package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
@zzzt
/* loaded from: classes.dex */
abstract class zzaki {
    private final WeakReference<View> zzdfl;

    public zzaki(View view) {
        this.zzdfl = new WeakReference<>(view);
    }

    private final ViewTreeObserver getViewTreeObserver() {
        View view = this.zzdfl.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void detach() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            zzb(viewTreeObserver);
        }
    }

    protected abstract void zza(ViewTreeObserver viewTreeObserver);

    protected abstract void zzb(ViewTreeObserver viewTreeObserver);

    public final void zzrt() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            zza(viewTreeObserver);
        }
    }
}
