package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
/* loaded from: classes2.dex */
public final class zzbva {
    private boolean zzaqo = false;
    private zzbvb zzhap = null;

    public final void initialize(Context context) {
        synchronized (this) {
            if (this.zzaqo) {
                return;
            }
            try {
                this.zzhap = zzbvc.asInterface(DynamiteModule.zza(context, DynamiteModule.zzgpk, ModuleDescriptor.MODULE_ID).zzgv("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.zzhap.init(com.google.android.gms.dynamic.zzn.zzw(context));
                this.zzaqo = true;
            } catch (RemoteException | DynamiteModule.zzc e) {
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            }
        }
    }

    public final <T> T zzb(zzbut<T> zzbutVar) {
        synchronized (this) {
            if (this.zzaqo) {
                return zzbutVar.zza(this.zzhap);
            }
            return zzbutVar.zzik();
        }
    }
}
