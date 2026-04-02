package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
final class zzox implements zzoc {
    private /* synthetic */ zzov zzbtq;
    private /* synthetic */ View zzbtr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzox(zzov zzovVar, View view) {
        this.zzbtq = zzovVar;
        this.zzbtr = view;
    }

    @Override // com.google.android.gms.internal.zzoc
    public final void zzc(MotionEvent motionEvent) {
        this.zzbtq.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.zzoc
    public final void zzjq() {
        this.zzbtq.onClick(this.zzbtr);
    }
}
