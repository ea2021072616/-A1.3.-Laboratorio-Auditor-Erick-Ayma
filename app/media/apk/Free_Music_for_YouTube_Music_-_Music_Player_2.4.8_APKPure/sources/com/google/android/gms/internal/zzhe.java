package com.google.android.gms.internal;

import android.view.View;
/* loaded from: classes2.dex */
final class zzhe implements Runnable {
    private /* synthetic */ View zzayy;
    private /* synthetic */ zzhd zzayz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhe(zzhd zzhdVar, View view) {
        this.zzayz = zzhdVar;
        this.zzayy = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzayz.zzf(this.zzayy);
    }
}
