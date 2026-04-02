package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
/* loaded from: classes.dex */
final class zzalm implements DialogInterface.OnClickListener {
    private /* synthetic */ JsPromptResult zzdih;
    private /* synthetic */ EditText zzdii;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalm(JsPromptResult jsPromptResult, EditText editText) {
        this.zzdih = jsPromptResult;
        this.zzdii = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdih.confirm(this.zzdii.getText().toString());
    }
}
