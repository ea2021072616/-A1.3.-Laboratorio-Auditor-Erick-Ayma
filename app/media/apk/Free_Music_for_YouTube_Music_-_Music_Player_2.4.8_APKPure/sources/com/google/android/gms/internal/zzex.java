package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzex extends zzfa {
    private final zzcu zzalh;
    private final zzcv zzali;
    private final zzcs zzalj;
    private boolean zzalk = false;

    public zzex(String str, Context context, boolean z) {
        this.zzalh = zzcu.zza(str, context, z);
        this.zzali = new zzcv(this.zzalh);
        this.zzalj = z ? null : zzcs.zzb(context);
    }

    private final IObjectWrapper zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, boolean z) {
        try {
            Uri uri = (Uri) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
            Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper2);
            return com.google.android.gms.dynamic.zzn.zzw(z ? this.zzali.zza(uri, context) : this.zzali.zza(uri, context, null));
        } catch (zzcw e) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return zza(iObjectWrapper, iObjectWrapper2, true);
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zza(IObjectWrapper iObjectWrapper, String str) {
        return this.zzalh.zza((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), str);
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zza(IObjectWrapper iObjectWrapper, byte[] bArr) {
        Context context = (Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper);
        String zza = this.zzalh.zza(context, bArr);
        if (this.zzalj == null || !this.zzalk) {
            return zza;
        }
        String zza2 = zzcs.zza(zza, this.zzalj.zza(context, bArr));
        this.zzalk = false;
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzez
    public final boolean zza(IObjectWrapper iObjectWrapper) {
        return this.zzali.zza((Uri) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzez
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return zza(iObjectWrapper, iObjectWrapper2, false);
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zzb(String str, String str2) {
        this.zzali.zzb(str, str2);
    }

    @Override // com.google.android.gms.internal.zzez
    public final boolean zzb(IObjectWrapper iObjectWrapper) {
        return this.zzali.zzc((Uri) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzez
    public final boolean zzb(String str, boolean z) {
        if (this.zzalj == null) {
            return false;
        }
        this.zzalj.zza(new AdvertisingIdClient.Info(str, z));
        this.zzalk = true;
        return true;
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zzbd() {
        return "ms";
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zzc(IObjectWrapper iObjectWrapper) {
        return zza(iObjectWrapper, (byte[]) null);
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zzd(IObjectWrapper iObjectWrapper) {
        this.zzali.zza((MotionEvent) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zzk(String str) {
        this.zzali.zzk(str);
    }
}
