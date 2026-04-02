package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagg extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ String zzdba;
    private /* synthetic */ long zzdbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagg(Context context, String str, long j) {
        super(null);
        this.zzaok = context;
        this.zzdba = str;
        this.zzdbb = j;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putString("app_settings_json", this.zzdba);
        edit.putLong("app_settings_last_update_ms", this.zzdbb);
        edit.apply();
    }
}
