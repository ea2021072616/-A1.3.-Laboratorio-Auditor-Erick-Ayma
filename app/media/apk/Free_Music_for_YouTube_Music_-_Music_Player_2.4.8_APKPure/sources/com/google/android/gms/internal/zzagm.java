package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagm extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ long zzdbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagm(Context context, long j) {
        super(null);
        this.zzaok = context;
        this.zzdbd = j;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putLong("app_last_background_time_ms", this.zzdbd);
        edit.apply();
    }
}
