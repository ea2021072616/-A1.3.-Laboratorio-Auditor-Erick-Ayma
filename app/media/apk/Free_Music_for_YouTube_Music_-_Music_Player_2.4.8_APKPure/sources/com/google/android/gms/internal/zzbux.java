package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzbux extends zzbut<Long> {
    public zzbux(int i, String str, Long l) {
        super(0, str, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzbut
    /* renamed from: zzd */
    public final Long zza(zzbvb zzbvbVar) {
        try {
            return Long.valueOf(zzbvbVar.getLongFlagValue(getKey(), zzik().longValue(), getSource()));
        } catch (RemoteException e) {
            return zzik();
        }
    }
}
