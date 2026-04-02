package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
final class zzalk implements DialogInterface.OnCancelListener {
    private /* synthetic */ JsPromptResult zzdih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalk(JsPromptResult jsPromptResult) {
        this.zzdih = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzdih.cancel();
    }
}
