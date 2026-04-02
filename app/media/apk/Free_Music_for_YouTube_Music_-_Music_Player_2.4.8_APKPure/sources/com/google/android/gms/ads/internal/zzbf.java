package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zzog;
import java.util.List;
/* loaded from: classes.dex */
final class zzbf implements Runnable {
    private /* synthetic */ zzbc zzara;
    private /* synthetic */ int zzarb;
    private /* synthetic */ zzog zzare;
    private /* synthetic */ List zzarf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(zzbc zzbcVar, zzog zzogVar, int i, List list) {
        this.zzara = zzbcVar;
        this.zzare = zzogVar;
        this.zzarb = i;
        this.zzarf = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if ((this.zzare instanceof zzny) && this.zzara.zzams.zzatw != null) {
                this.zzara.zzamq = this.zzarb != this.zzarf.size() + (-1);
                this.zzara.zzams.zzatw.zza((zzny) this.zzare);
            } else if (!(this.zzare instanceof zznw) || this.zzara.zzams.zzatv == null) {
                this.zzara.zzc(3, this.zzarb != this.zzarf.size() + (-1));
            } else {
                this.zzara.zzamq = this.zzarb != this.zzarf.size() + (-1);
                this.zzara.zzams.zzatv.zza((zznw) this.zzare);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Could not call onAppInstallAdLoaded or onContentAdLoaded method", e);
        }
    }
}
