package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagu extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzagy zzday;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagu(Context context, zzagy zzagyVar) {
        super(null);
        this.zzaok = context;
        this.zzday = zzagyVar;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences sharedPreferences = this.zzaok.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("content_url_opted_out", sharedPreferences.getBoolean("content_url_opted_out", true));
        if (this.zzday != null) {
            this.zzday.zzb(bundle);
        }
    }
}
