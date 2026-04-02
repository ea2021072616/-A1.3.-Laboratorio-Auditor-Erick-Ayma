package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
final class zzn implements View.OnTouchListener {
    private /* synthetic */ zzl zzanh;
    private /* synthetic */ zzw zzani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzl zzlVar, zzw zzwVar) {
        this.zzanh = zzlVar;
        this.zzani = zzwVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zzani.recordClick();
        if (this.zzanh.zzanf != null) {
            this.zzanh.zzanf.zzpd();
            return false;
        }
        return false;
    }
}
