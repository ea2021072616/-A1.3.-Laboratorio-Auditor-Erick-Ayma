package com.google.android.gms.internal;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakm implements Runnable {
    private /* synthetic */ View val$view;
    private /* synthetic */ zzaev zzdgh;
    private /* synthetic */ int zzdgi;
    private /* synthetic */ zzakl zzdgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakm(zzakl zzaklVar, View view, zzaev zzaevVar, int i) {
        this.zzdgj = zzaklVar;
        this.val$view = view;
        this.zzdgh = zzaevVar;
        this.zzdgi = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdgj.zza(this.val$view, this.zzdgh, this.zzdgi - 1);
    }
}
