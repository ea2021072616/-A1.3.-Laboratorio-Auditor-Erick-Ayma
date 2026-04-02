package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
@TargetApi(18)
/* loaded from: classes.dex */
public class zzahr extends zzahq {
    @Override // com.google.android.gms.internal.zzahk
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final int zzra() {
        return 14;
    }
}
