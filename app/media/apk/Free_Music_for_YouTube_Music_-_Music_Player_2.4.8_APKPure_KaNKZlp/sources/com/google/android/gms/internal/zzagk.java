package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagk extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzagy zzday;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagk(Context context, zzagy zzagyVar) {
        super(null);
        this.zzaok = context;
        this.zzday = zzagyVar;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences sharedPreferences = this.zzaok.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putString("native_advanced_settings", sharedPreferences.getString("native_advanced_settings", "{}"));
        if (this.zzday != null) {
            this.zzday.zzb(bundle);
        }
    }
}
