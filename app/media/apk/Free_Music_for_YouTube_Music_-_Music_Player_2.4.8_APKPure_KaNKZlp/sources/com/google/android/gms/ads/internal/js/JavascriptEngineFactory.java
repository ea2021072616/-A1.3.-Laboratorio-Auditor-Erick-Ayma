package com.google.android.gms.ads.internal.js;

import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzajx;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class JavascriptEngineFactory {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class JSEngineSettableFuture extends zzajx<zza> {
        @Keep
        zza mEngineReference;

        private JSEngineSettableFuture() {
        }

        /* synthetic */ JSEngineSettableFuture(zzc zzcVar) {
            this();
        }
    }

    public final zzajr<zza> zza(Context context, zzajk zzajkVar, String str, zzcv zzcvVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        JSEngineSettableFuture jSEngineSettableFuture = new JSEngineSettableFuture(null);
        zzahf.zzdbo.post(new zzc(this, context, zzajkVar, zzcvVar, zzvVar, jSEngineSettableFuture, str));
        return jSEngineSettableFuture;
    }
}
