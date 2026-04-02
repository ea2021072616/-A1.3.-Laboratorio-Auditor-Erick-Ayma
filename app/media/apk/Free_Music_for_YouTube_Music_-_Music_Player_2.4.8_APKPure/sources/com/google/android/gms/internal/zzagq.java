package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagq extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ long zzdbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagq(Context context, long j) {
        super(null);
        this.zzaok = context;
        this.zzdbf = j;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putLong("first_ad_req_time_ms", this.zzdbf);
        edit.apply();
    }
}
