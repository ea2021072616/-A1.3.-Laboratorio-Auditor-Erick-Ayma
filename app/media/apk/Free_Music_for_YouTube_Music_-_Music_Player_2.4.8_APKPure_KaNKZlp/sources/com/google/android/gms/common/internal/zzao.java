package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzeg;
/* loaded from: classes.dex */
public final class zzao extends zzee implements zzam {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.zzam
    public final Account getAccount() throws RemoteException {
        Parcel zza = zza(2, zzax());
        Account account = (Account) zzeg.zza(zza, Account.CREATOR);
        zza.recycle();
        return account;
    }
}
