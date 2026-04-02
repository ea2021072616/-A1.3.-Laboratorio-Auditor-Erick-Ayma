package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzcv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzm implements Runnable {
    final /* synthetic */ zzcv zzbyy;
    final /* synthetic */ zzac zzbyz;
    final /* synthetic */ zzl zzbza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzl zzlVar, zzcv zzcvVar, zzac zzacVar) {
        this.zzbza = zzlVar;
        this.zzbyy = zzcvVar;
        this.zzbyz = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        zzajk zzajkVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            context = this.zzbza.mContext;
            zzajkVar = this.zzbza.zzapc;
            zze zzeVar = new zze(context, zzajkVar, this.zzbyy, null);
            zzeVar.zza(new zzn(this, zzeVar));
            zzeVar.zza("/jsLoaded", new zzq(this, zzeVar));
            zzaiy zzaiyVar = new zzaiy();
            zzr zzrVar = new zzr(this, zzeVar, zzaiyVar);
            zzaiyVar.set(zzrVar);
            zzeVar.zza("/requestReload", zzrVar);
            str = this.zzbza.zzbyt;
            if (str.endsWith(".js")) {
                str5 = this.zzbza.zzbyt;
                zzeVar.zzbc(str5);
            } else {
                str2 = this.zzbza.zzbyt;
                if (str2.startsWith("<html>")) {
                    str4 = this.zzbza.zzbyt;
                    zzeVar.zzbe(str4);
                } else {
                    str3 = this.zzbza.zzbyt;
                    zzeVar.zzbd(str3);
                }
            }
            zzahf.zzdbo.postDelayed(new zzs(this, zzeVar), zzw.zzbzi);
        } catch (Throwable th) {
            zzafx.zzb("Error creating webview.", th);
            zzbv.zzee().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            this.zzbyz.reject();
        }
    }
}
