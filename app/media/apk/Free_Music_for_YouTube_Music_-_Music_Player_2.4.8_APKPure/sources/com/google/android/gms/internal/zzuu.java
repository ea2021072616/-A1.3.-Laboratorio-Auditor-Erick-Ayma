package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzt
/* loaded from: classes.dex */
public final class zzuu implements zzuj {
    private final Context mContext;
    private final long mStartTime;
    private final zzva zzana;
    private final boolean zzauz;
    private final zzul zzcbo;
    private final boolean zzcbs;
    private final zzaak zzccg;
    private final long zzcch;
    private final String zzccl;
    private final Object mLock = new Object();
    private boolean zzccj = false;
    private final Map<zzajr<zzur>, zzuo> zzcck = new HashMap();
    private List<zzur> zzccm = new ArrayList();
    private final int zzcci = 2;

    public zzuu(Context context, zzaak zzaakVar, zzva zzvaVar, zzul zzulVar, boolean z, boolean z2, String str, long j, long j2, int i) {
        this.mContext = context;
        this.zzccg = zzaakVar;
        this.zzana = zzvaVar;
        this.zzcbo = zzulVar;
        this.zzauz = z;
        this.zzcbs = z2;
        this.zzccl = str;
        this.mStartTime = j;
        this.zzcch = j2;
    }

    private final void zza(zzajr<zzur> zzajrVar) {
        zzahf.zzdbo.post(new zzuw(this, zzajrVar));
    }

    private final zzur zzh(List<zzajr<zzur>> list) {
        synchronized (this.mLock) {
            if (this.zzccj) {
                return new zzur(-1);
            }
            for (zzajr<zzur> zzajrVar : list) {
                try {
                    zzur zzurVar = zzajrVar.get();
                    this.zzccm.add(zzurVar);
                    if (zzurVar != null && zzurVar.zzcbz == 0) {
                        zza(zzajrVar);
                        return zzurVar;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzafx.zzc("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            zza((zzajr<zzur>) null);
            return new zzur(1);
        }
    }

    private final zzur zzi(List<zzajr<zzur>> list) {
        zzur zzurVar;
        zzur zzurVar2;
        zzajr<zzur> zzajrVar;
        int i;
        zzvj zzvjVar;
        synchronized (this.mLock) {
            if (this.zzccj) {
                return new zzur(-1);
            }
            int i2 = -1;
            zzajr<zzur> zzajrVar2 = null;
            zzur zzurVar3 = null;
            long j = this.zzcbo.zzcbe != -1 ? this.zzcbo.zzcbe : 10000L;
            long j2 = j;
            for (zzajr<zzur> zzajrVar3 : list) {
                long currentTimeMillis = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
                if (j2 == 0) {
                    try {
                        try {
                        } catch (Throwable th) {
                            Math.max(j2 - (com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis() - currentTimeMillis), 0L);
                            throw th;
                        }
                    } catch (RemoteException | InterruptedException | ExecutionException | TimeoutException e) {
                        zzafx.zzc("Exception while processing an adapter; continuing with other adapters", e);
                        j2 = Math.max(j2 - (com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis() - currentTimeMillis), 0L);
                    }
                    if (zzajrVar3.isDone()) {
                        zzurVar = zzajrVar3.get();
                        this.zzccm.add(zzurVar);
                        if (zzurVar != null || zzurVar.zzcbz != 0 || (zzvjVar = zzurVar.zzcce) == null || zzvjVar.zzlq() <= i2) {
                            zzurVar2 = zzurVar3;
                            zzajrVar = zzajrVar2;
                            i = i2;
                        } else {
                            i = zzvjVar.zzlq();
                            zzur zzurVar4 = zzurVar;
                            zzajrVar = zzajrVar3;
                            zzurVar2 = zzurVar4;
                        }
                        j2 = Math.max(j2 - (com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis() - currentTimeMillis), 0L);
                        zzajrVar2 = zzajrVar;
                        i2 = i;
                        zzurVar3 = zzurVar2;
                    }
                }
                zzurVar = zzajrVar3.get(j2, TimeUnit.MILLISECONDS);
                this.zzccm.add(zzurVar);
                if (zzurVar != null) {
                }
                zzurVar2 = zzurVar3;
                zzajrVar = zzajrVar2;
                i = i2;
                j2 = Math.max(j2 - (com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis() - currentTimeMillis), 0L);
                zzajrVar2 = zzajrVar;
                i2 = i;
                zzurVar3 = zzurVar2;
            }
            zza(zzajrVar2);
            return zzurVar3 == null ? new zzur(1) : zzurVar3;
        }
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzccj = true;
            for (zzuo zzuoVar : this.zzcck.values()) {
                zzuoVar.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzuj
    public final zzur zzg(List<zzuk> list) {
        zzjb zzjbVar;
        zzafx.zzcb("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
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
                zzuo zzuoVar = new zzuo(this.mContext, str, this.zzana, this.zzcbo, zzukVar, this.zzccg.zzcnw, zzjbVar, this.zzccg.zzatj, this.zzauz, this.zzcbs, this.zzccg.zzatz, this.zzccg.zzaug, this.zzccg.zzcol, this.zzccg.zzcpg);
                zzajr<zzur> zza = zzagz.zza(newCachedThreadPool, new zzuv(this, zzuoVar));
                this.zzcck.put(zza, zzuoVar);
                arrayList.add(zza);
            }
        }
        switch (this.zzcci) {
            case 2:
                return zzi(arrayList);
            default:
                return zzh(arrayList);
        }
    }

    @Override // com.google.android.gms.internal.zzuj
    public final List<zzur> zzli() {
        return this.zzccm;
    }
}
