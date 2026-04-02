package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
final class zzagb extends zzagx {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ String zzdaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagb(Context context, String str) {
        super(null);
        this.zzaok = context;
        this.zzdaw = str;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        SharedPreferences.Editor edit = this.zzaok.getSharedPreferences("admob", 0).edit();
        edit.putString("content_vertical_hashes", this.zzdaw);
        edit.apply();
    }
}
