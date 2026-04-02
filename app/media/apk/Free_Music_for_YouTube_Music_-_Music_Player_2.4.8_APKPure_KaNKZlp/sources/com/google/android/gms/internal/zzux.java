package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzux implements zzuj {
    private final Context mContext;
    private final long mStartTime;
    private final zznh zzamn;
    private final zzva zzana;
    private final boolean zzauz;
    private final zzul zzcbo;
    private final boolean zzcbs;
    private final zzaak zzccg;
    private final long zzcch;
    private final String zzccl;
    private zzuo zzccq;
    private final Object mLock = new Object();
    private boolean zzccj = false;
    private List<zzur> zzccm = new ArrayList();

    public zzux(Context context, zzaak zzaakVar, zzva zzvaVar, zzul zzulVar, boolean z, boolean z2, String str, long j, long j2, zznh zznhVar) {
        this.mContext = context;
        this.zzccg = zzaakVar;
        this.zzana = zzvaVar;
        this.zzcbo = zzulVar;
        this.zzauz = z;
        this.zzcbs = z2;
        this.zzccl = str;
        this.mStartTime = j;
        this.zzcch = j2;
        this.zzamn = zznhVar;
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzccj = true;
            if (this.zzccq != null) {
                this.zzccq.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzuj
    public final zzur zzg(List<zzuk> list) {
        zzjb zzjbVar;
        zzafx.zzcb("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zznf zziu = this.zzamn.zziu();
        zzjb zzjbVar2 = this.zzccg.zzatn;
        int[] iArr = new int[2];
        if (zzjbVar2.zzbcs != null) {
            com.google.android.gms.ads.internal.zzbv.zzeu();
            if (zzut.zza(this.zzccl, iArr)) {
                int i = iArr[0];
                int i2 = iArr[1];
                zzjb[] zzjbVarArr = zzjbVar2.zzbcs;
                int length = zzjbVarArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    zzjbVar = zzjbVarArr[i3];
                    if (i == zzjbVar.width && i2 == zzjbVar.height) {
                        break;
                    }
                }
            }
        }
        zzjbVar = zzjbVar2;
        for (zzuk zzukVar : list) {
            String valueOf = String.valueOf(zzukVar.zzcab);
            zzafx.zzcr(valueOf.length() != 0 ? "Trying mediation network: ".concat(valueOf) : new String("Trying mediation network: "));
            for (String str : zzukVar.zzcac) {
                zznf zziu2 = this.zzamn.zziu();
                synchronized (this.mLock) {
                    if (this.zzccj) {
                        return new zzur(-1);
                    }
                    this.zzccq = new zzuo(this.mContext, str, this.zzana, this.zzcbo, zzukVar, this.zzccg.zzcnw, zzjbVar, this.zzccg.zzatj, this.zzauz, this.zzcbs, this.zzccg.zzatz, this.zzccg.zzaug, this.zzccg.zzcol, this.zzccg.zzcpg);
                    zzur zza = this.zzccq.zza(this.mStartTime, this.zzcch);
                    this.zzccm.add(zza);
                    if (zza.zzcbz == 0) {
                        zzafx.zzcb("Adapter succeeded.");
                        this.zzamn.zzh("mediation_network_succeed", str);
                        if (!arrayList.isEmpty()) {
                            this.zzamn.zzh("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.zzamn.zza(zziu2, "mls");
                        this.zzamn.zza(zziu, "ttm");
                        return zza;
                    }
                    arrayList.add(str);
                    this.zzamn.zza(zziu2, "mlf");
                    if (zza.zzccb != null) {
                        zzahf.zzdbo.post(new zzuy(this, zza));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzamn.zzh("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzur(1);
    }

    @Override // com.google.android.gms.internal.zzuj
    public final List<zzur> zzli() {
        return this.zzccm;
    }
}
