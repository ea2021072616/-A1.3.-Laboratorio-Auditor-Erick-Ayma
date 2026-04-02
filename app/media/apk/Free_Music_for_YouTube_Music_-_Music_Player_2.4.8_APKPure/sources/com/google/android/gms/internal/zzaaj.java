package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
@zzzt
/* loaded from: classes.dex */
public final class zzaaj extends com.google.android.gms.common.internal.zzd<zzaas> {
    private int zzcnu;

    public zzaaj(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar, int i) {
        super(context, looper, 8, zzfVar, zzgVar, null);
        this.zzcnu = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzaas zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return queryLocalInterface instanceof zzaas ? (zzaas) queryLocalInterface : new zzaau(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhc() {
        return "com.google.android.gms.ads.service.START";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public final zzaas zzof() throws DeadObjectException {
        return (zzaas) super.zzajj();
    }
}
