package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
@zzzt
/* loaded from: classes.dex */
public final class zzio {
    zzfe zzbbb;
    boolean zzbbc;

    public zzio() {
    }

    public zzio(Context context) {
        zzmu.initialize(context);
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbph)).booleanValue()) {
            try {
                this.zzbbb = zzff.zzc(DynamiteModule.zza(context, DynamiteModule.zzgpf, ModuleDescriptor.MODULE_ID).zzgv("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
                com.google.android.gms.dynamic.zzn.zzw(context);
                this.zzbbb.zzb(com.google.android.gms.dynamic.zzn.zzw(context), "GMA_SDK");
                this.zzbbc = true;
            } catch (RemoteException | DynamiteModule.zzc | NullPointerException e) {
                zzafx.v("Cannot dynamite load clearcut");
            }
        }
    }

    public zzio(Context context, String str, String str2) {
        zzmu.initialize(context);
        try {
            this.zzbbb = zzff.zzc(DynamiteModule.zza(context, DynamiteModule.zzgpf, ModuleDescriptor.MODULE_ID).zzgv("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
            com.google.android.gms.dynamic.zzn.zzw(context);
            this.zzbbb.zza(com.google.android.gms.dynamic.zzn.zzw(context), str, null);
            this.zzbbc = true;
        } catch (RemoteException | DynamiteModule.zzc | NullPointerException e) {
            zzafx.v("Cannot dynamite load clearcut");
        }
    }

    public final zziq zzd(byte[] bArr) {
        return new zziq(this, bArr);
    }
}
