package com.google.android.gms.internal;

import android.view.View;
/* loaded from: classes2.dex */
final class zzwu implements View.OnClickListener {
    private /* synthetic */ zzwt zzcee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwu(zzwt zzwtVar) {
        this.zzcee = zzwtVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzcee.zzl(true);
    }
}
