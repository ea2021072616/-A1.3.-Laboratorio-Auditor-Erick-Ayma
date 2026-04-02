package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
final class zzadu implements Runnable {
    private /* synthetic */ zzix zzape;
    private /* synthetic */ zzvd zzcwf;
    private /* synthetic */ zzads zzcwg;
    private /* synthetic */ zzaea zzcwh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadu(zzads zzadsVar, zzvd zzvdVar, zzix zzixVar, zzaea zzaeaVar) {
        this.zzcwg = zzadsVar;
        this.zzcwf = zzvdVar;
        this.zzape = zzixVar;
        this.zzcwh = zzaeaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        Context context;
        String str3;
        try {
            zzvd zzvdVar = this.zzcwf;
            context = this.zzcwg.mContext;
            IObjectWrapper zzw = com.google.android.gms.dynamic.zzn.zzw(context);
            zzix zzixVar = this.zzape;
            zzaea zzaeaVar = this.zzcwh;
            str3 = this.zzcwg.zzcwa;
            zzvdVar.zza(zzw, zzixVar, (String) null, zzaeaVar, str3);
        } catch (RemoteException e) {
            str = this.zzcwg.zzcbm;
            String valueOf = String.valueOf(str);
            zzafx.zzc(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), e);
            zzads zzadsVar = this.zzcwg;
            str2 = this.zzcwg.zzcbm;
            zzadsVar.zza(str2, 0);
        }
    }
}
