package com.google.android.gms.ads.internal;

import android.view.View;
/* loaded from: classes.dex */
final class zzo implements View.OnClickListener {
    private /* synthetic */ zzl zzanh;
    private /* synthetic */ zzw zzani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzl zzlVar, zzw zzwVar) {
        this.zzanh = zzlVar;
        this.zzani = zzwVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzani.recordClick();
        if (this.zzanh.zzanf != null) {
            this.zzanh.zzanf.zzpd();
        }
    }
}
