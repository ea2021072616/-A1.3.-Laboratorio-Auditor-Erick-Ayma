package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
/* loaded from: classes.dex */
final class zzalh implements DialogInterface.OnCancelListener {
    private /* synthetic */ JsResult zzdig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalh(JsResult jsResult) {
        this.zzdig = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzdig.cancel();
    }
}
