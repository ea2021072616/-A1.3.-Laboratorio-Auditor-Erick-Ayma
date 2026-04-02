package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzbuv extends zzbut<Boolean> {
    public zzbuv(int i, String str, Boolean bool) {
        super(0, str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzbut
    /* renamed from: zzb */
    public final Boolean zza(zzbvb zzbvbVar) {
        try {
            return Boolean.valueOf(zzbvbVar.getBooleanFlagValue(getKey(), zzik().booleanValue(), getSource()));
        } catch (RemoteException e) {
            return zzik();
        }
    }
}
