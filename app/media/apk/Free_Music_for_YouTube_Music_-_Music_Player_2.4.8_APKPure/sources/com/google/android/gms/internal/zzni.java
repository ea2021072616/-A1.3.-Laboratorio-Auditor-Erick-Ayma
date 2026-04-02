package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzni extends zznl {
    private final com.google.android.gms.ads.internal.zzag zzbqs;
    @Nullable
    private final String zzbqt;
    private final String zzbqu;

    public zzni(com.google.android.gms.ads.internal.zzag zzagVar, @Nullable String str, String str2) {
        this.zzbqs = zzagVar;
        this.zzbqt = str;
        this.zzbqu = str2;
    }

    @Override // com.google.android.gms.internal.zznk
    public final String getContent() {
        return this.zzbqu;
    }

    @Override // com.google.android.gms.internal.zznk
    public final void recordClick() {
        this.zzbqs.zzck();
    }

    @Override // com.google.android.gms.internal.zznk
    public final void recordImpression() {
        this.zzbqs.zzcl();
    }

    @Override // com.google.android.gms.internal.zznk
    public final void zzi(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zzbqs.zzc((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zznk
    public final String zziz() {
        return this.zzbqt;
    }
}
