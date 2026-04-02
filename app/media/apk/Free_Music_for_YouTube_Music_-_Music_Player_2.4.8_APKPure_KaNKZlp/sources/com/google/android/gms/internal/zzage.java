package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzage extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ int zzdaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzage(Context context, int i) {
        super(null);
        this.zzaok = context;
        this.zzdaz = i;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putInt("version_code", this.zzdaz);
        edit.apply();
    }
}
