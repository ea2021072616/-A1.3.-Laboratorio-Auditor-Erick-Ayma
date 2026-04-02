package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbo;
@zzzt
/* loaded from: classes.dex */
public final class zzaku {
    public final zzakk zza(Context context, zzjb zzjbVar, boolean z, boolean z2, @Nullable zzcv zzcvVar, zzajk zzajkVar, zznh zznhVar, zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar, zzil zzilVar) throws zzakw {
        try {
            return (zzakk) zzaiz.zzb(new zzakv(this, context, zzjbVar, z, z2, zzcvVar, zzajkVar, zznhVar, zzboVar, zzvVar, zzilVar));
        } catch (Throwable th) {
            throw new zzakw(this, "Webview initialization failed.", th);
        }
    }
}
