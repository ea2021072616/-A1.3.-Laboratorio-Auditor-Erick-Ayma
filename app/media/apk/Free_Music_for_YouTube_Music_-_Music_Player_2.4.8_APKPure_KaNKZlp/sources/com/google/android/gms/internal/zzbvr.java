package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class zzbvr extends com.google.android.gms.common.internal.zzd<zzbvw> {
    public zzbvr(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar) {
        super(context, looper, 116, zzfVar, zzgVar, null);
    }

    public final zzbvw zzasc() throws DeadObjectException {
        return (zzbvw) super.zzajj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzbvw zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return queryLocalInterface instanceof zzbvw ? (zzbvw) queryLocalInterface : new zzbvx(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhc() {
        return "com.google.android.gms.gass.START";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.gass.internal.IGassService";
    }
}
