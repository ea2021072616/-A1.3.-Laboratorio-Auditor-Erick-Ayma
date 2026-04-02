package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class zzy extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    private int version;
    private int zzftw;
    private int zzftx;
    String zzfty;
    IBinder zzftz;
    Scope[] zzfua;
    Bundle zzfub;
    Account zzfuc;
    com.google.android.gms.common.zzc[] zzfud;

    public zzy(int i) {
        this.version = 3;
        this.zzftx = com.google.android.gms.common.zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzftw = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, com.google.android.gms.common.zzc[] zzcVarArr) {
        Account account2 = null;
        zzam zzaoVar = null;
        this.version = i;
        this.zzftw = i2;
        this.zzftx = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzfty = "com.google.android.gms";
        } else {
            this.zzfty = str;
        }
        if (i < 2) {
            if (iBinder != null) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    zzaoVar = queryLocalInterface instanceof zzam ? (zzam) queryLocalInterface : new zzao(iBinder);
                }
                account2 = zza.zza(zzaoVar);
            }
            this.zzfuc = account2;
        } else {
            this.zzftz = iBinder;
            this.zzfuc = account;
        }
        this.zzfua = scopeArr;
        this.zzfub = bundle;
        this.zzfud = zzcVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.version);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 2, this.zzftw);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.zzftx);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzfty, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzftz, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, (Parcelable[]) this.zzfua, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzfub, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, (Parcelable) this.zzfuc, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, (Parcelable[]) this.zzfud, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}
