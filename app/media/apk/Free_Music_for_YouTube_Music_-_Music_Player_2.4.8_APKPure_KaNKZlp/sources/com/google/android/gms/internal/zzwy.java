package com.google.android.gms.internal;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class zzwy implements DialogInterface.OnClickListener {
    private /* synthetic */ zzww zzcej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwy(zzww zzwwVar) {
        this.zzcej = zzwwVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzcej.zzbn("User canceled the download.");
    }
}
