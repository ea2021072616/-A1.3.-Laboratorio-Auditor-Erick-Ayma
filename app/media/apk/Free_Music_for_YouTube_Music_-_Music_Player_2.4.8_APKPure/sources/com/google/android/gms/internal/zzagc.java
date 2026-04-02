package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagc extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ boolean zzdax;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagc(Context context, boolean z) {
        super(null);
        this.zzaok = context;
        this.zzdax = z;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("auto_collect_location", this.zzdax);
        edit.apply();
    }
}
