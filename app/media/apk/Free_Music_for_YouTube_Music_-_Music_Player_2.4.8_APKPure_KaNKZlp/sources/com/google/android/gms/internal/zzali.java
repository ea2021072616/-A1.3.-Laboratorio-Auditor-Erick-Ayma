package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
/* loaded from: classes.dex */
final class zzali implements DialogInterface.OnClickListener {
    private /* synthetic */ JsResult zzdig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzali(JsResult jsResult) {
        this.zzdig = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdig.cancel();
    }
}
