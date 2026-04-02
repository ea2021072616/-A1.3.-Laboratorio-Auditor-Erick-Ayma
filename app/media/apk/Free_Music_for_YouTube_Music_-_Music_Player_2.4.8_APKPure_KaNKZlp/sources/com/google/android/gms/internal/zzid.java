package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
@zzzt
/* loaded from: classes.dex */
public final class zzid extends com.google.android.gms.common.internal.zzd<zzih> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar) {
        super(context, looper, 123, zzfVar, zzgVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzih zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        return queryLocalInterface instanceof zzih ? (zzih) queryLocalInterface : new zzii(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhc() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public final zzih zzhe() throws DeadObjectException {
        return (zzih) super.zzajj();
    }
}
