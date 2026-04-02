package com.google.android.gms.internal;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakn implements View.OnAttachStateChangeListener {
    private /* synthetic */ zzaev zzdgh;
    private /* synthetic */ zzakl zzdgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakn(zzakl zzaklVar, zzaev zzaevVar) {
        this.zzdgj = zzaklVar;
        this.zzdgh = zzaevVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzdgj.zza(view, this.zzdgh, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
