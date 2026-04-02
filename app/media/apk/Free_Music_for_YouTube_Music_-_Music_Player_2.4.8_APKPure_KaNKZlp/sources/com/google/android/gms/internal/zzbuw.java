package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzbuw extends zzbut<Integer> {
    public zzbuw(int i, String str, Integer num) {
        super(0, str, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzbut
    /* renamed from: zzc */
    public final Integer zza(zzbvb zzbvbVar) {
        try {
            return Integer.valueOf(zzbvbVar.getIntFlagValue(getKey(), zzik().intValue(), getSource()));
        } catch (RemoteException e) {
            return zzik();
        }
    }
}
