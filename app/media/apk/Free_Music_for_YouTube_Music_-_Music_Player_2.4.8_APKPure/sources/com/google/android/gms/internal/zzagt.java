package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagt extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ boolean zzdbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagt(Context context, boolean z) {
        super(null);
        this.zzaok = context;
        this.zzdbg = z;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("content_url_opted_out", this.zzdbg);
        edit.apply();
    }
}
