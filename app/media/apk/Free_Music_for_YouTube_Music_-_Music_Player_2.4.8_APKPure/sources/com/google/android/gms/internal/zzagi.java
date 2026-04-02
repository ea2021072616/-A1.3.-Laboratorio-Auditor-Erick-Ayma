package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagi extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ String zzdbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagi(Context context, String str) {
        super(null);
        this.zzaok = context;
        this.zzdbc = str;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putString("native_advanced_settings", this.zzdbc);
        edit.apply();
    }
}
