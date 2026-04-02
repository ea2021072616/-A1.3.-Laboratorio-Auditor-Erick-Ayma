package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
final class zzall implements DialogInterface.OnClickListener {
    private /* synthetic */ JsPromptResult zzdih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzall(JsPromptResult jsPromptResult) {
        this.zzdih = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdih.cancel();
    }
}
