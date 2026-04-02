package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.ads.AdRequest;
/* loaded from: classes2.dex */
public final class zziq {
    private final byte[] zzbbd;
    private int zzbbe;
    private int zzbbf;
    private int[] zzbbg;
    private /* synthetic */ zzio zzbbh;

    private zziq(zzio zzioVar, byte[] bArr) {
        this.zzbbh = zzioVar;
        this.zzbbd = bArr;
    }

    public final zziq zzb(int[] iArr) {
        this.zzbbg = iArr;
        return this;
    }

    public final synchronized void zzbe() {
        try {
            if (this.zzbbh.zzbbc) {
                this.zzbbh.zzbbb.zzc(this.zzbbd);
                this.zzbbh.zzbbb.zze(this.zzbbe);
                this.zzbbh.zzbbb.zzf(this.zzbbf);
                this.zzbbh.zzbbb.zza(this.zzbbg);
                this.zzbbh.zzbbb.zzbe();
            }
        } catch (RemoteException e) {
            if (zzafx.zzqr()) {
                Log.v(AdRequest.LOGTAG, "Clearcut log failed", e);
            }
        }
    }

    public final zziq zzn(int i) {
        this.zzbbe = i;
        return this;
    }

    public final zziq zzo(int i) {
        this.zzbbf = i;
        return this;
    }
}
