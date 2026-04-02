package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
@TargetApi(19)
/* loaded from: classes.dex */
public class zzaht extends zzahr {
    @Override // com.google.android.gms.internal.zzahr, com.google.android.gms.internal.zzahk
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.zzahk
    public final ViewGroup.LayoutParams zzrb() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
