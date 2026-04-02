package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzbuy extends zzbut<String> {
    public zzbuy(int i, String str, String str2) {
        super(0, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzbut
    /* renamed from: zze */
    public final String zza(zzbvb zzbvbVar) {
        try {
            return zzbvbVar.getStringFlagValue(getKey(), zzik(), getSource());
        } catch (RemoteException e) {
            return zzik();
        }
    }
}
