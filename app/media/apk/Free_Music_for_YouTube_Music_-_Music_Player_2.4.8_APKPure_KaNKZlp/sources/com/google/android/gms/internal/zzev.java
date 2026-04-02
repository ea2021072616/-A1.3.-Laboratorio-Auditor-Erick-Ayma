package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzev {
    private final zzez zzalg;

    public zzev(String str, Context context, boolean z) {
        this.zzalg = zzey.zzb(str, context, false);
    }

    public final void zza(MotionEvent motionEvent) throws RemoteException {
        this.zzalg.zzd(com.google.android.gms.dynamic.zzn.zzw(motionEvent));
    }

    public final Uri zzb(Uri uri, Context context) throws zzew, RemoteException {
        IObjectWrapper zza = this.zzalg.zza(com.google.android.gms.dynamic.zzn.zzw(uri), com.google.android.gms.dynamic.zzn.zzw(context));
        if (zza == null) {
            throw new zzew();
        }
        return (Uri) com.google.android.gms.dynamic.zzn.zzab(zza);
    }

    public final Uri zzc(Uri uri, Context context) throws zzew, RemoteException {
        IObjectWrapper zzb = this.zzalg.zzb(com.google.android.gms.dynamic.zzn.zzw(uri), com.google.android.gms.dynamic.zzn.zzw(context));
        if (zzb == null) {
            throw new zzew();
        }
        return (Uri) com.google.android.gms.dynamic.zzn.zzab(zzb);
    }
}
