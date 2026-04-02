package com.google.android.gms.internal;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class zzws implements DialogInterface.OnClickListener {
    private /* synthetic */ zzwq zzcdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzws(zzwq zzwqVar) {
        this.zzcdq = zzwqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzcdq.zzbn("Operation denied by user.");
    }
}
