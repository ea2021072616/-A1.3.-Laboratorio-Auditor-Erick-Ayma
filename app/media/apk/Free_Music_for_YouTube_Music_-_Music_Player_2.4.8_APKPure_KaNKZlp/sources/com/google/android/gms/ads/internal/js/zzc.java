package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.js.JavascriptEngineFactory;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zzcv;
/* loaded from: classes.dex */
final class zzc implements Runnable {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzajk zzbyh;
    private /* synthetic */ zzcv zzbyi;
    private /* synthetic */ com.google.android.gms.ads.internal.zzv zzbyj;
    final /* synthetic */ JavascriptEngineFactory.JSEngineSettableFuture zzbyk;
    private /* synthetic */ String zzbyl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(JavascriptEngineFactory javascriptEngineFactory, Context context, zzajk zzajkVar, zzcv zzcvVar, com.google.android.gms.ads.internal.zzv zzvVar, JavascriptEngineFactory.JSEngineSettableFuture jSEngineSettableFuture, String str) {
        this.zzaok = context;
        this.zzbyh = zzajkVar;
        this.zzbyi = zzcvVar;
        this.zzbyj = zzvVar;
        this.zzbyk = jSEngineSettableFuture;
        this.zzbyl = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zze zzeVar = new zze(this.zzaok, this.zzbyh, this.zzbyi, this.zzbyj);
            this.zzbyk.mEngineReference = zzeVar;
            zzeVar.zza(new zzd(this));
            zzeVar.zzbd(this.zzbyl);
        } catch (zzakw e) {
            this.zzbyk.setException(e);
        }
    }
}
