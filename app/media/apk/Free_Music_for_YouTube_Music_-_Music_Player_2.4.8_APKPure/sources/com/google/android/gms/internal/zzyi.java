package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.a.a.a.d.b;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@zzzt
/* loaded from: classes.dex */
public final class zzyi extends zzxy {
    private final zznh zzamn;
    private zzva zzana;
    private final zzakk zzbvz;
    private zzul zzcbo;
    private zzuj zzckv;
    protected zzur zzckw;
    private boolean zzckx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyi(Context context, zzafj zzafjVar, zzva zzvaVar, zzyd zzydVar, zznh zznhVar, zzakk zzakkVar) {
        super(context, zzafjVar, zzydVar);
        this.zzana = zzvaVar;
        this.zzcbo = zzafjVar.zzcye;
        this.zzamn = zznhVar;
        this.zzbvz = zzakkVar;
    }

    private static String zzj(List<zzur> list) {
        int i;
        if (list == null) {
            return "".toString();
        }
        String str = "";
        for (zzur zzurVar : list) {
            if (zzurVar != null && zzurVar.zzcca != null && !TextUtils.isEmpty(zzurVar.zzcca.zzcad)) {
                String valueOf = String.valueOf(str);
                String str2 = zzurVar.zzcca.zzcad;
                switch (zzurVar.zzcbz) {
                    case -1:
                        i = 4;
                        break;
                    case 0:
                        i = 0;
                        break;
                    case 1:
                        i = 1;
                        break;
                    case 2:
                    default:
                        i = 6;
                        break;
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 3;
                        break;
                    case 5:
                        i = 5;
                        break;
                }
                String sb = new StringBuilder(String.valueOf(str2).length() + 33).append(str2).append(".").append(i).append(".").append(zzurVar.zzccf).toString();
                str = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb).length()).append(valueOf).append(sb).append(b.ROLL_OVER_FILE_NAME_SEPARATOR).toString();
            }
        }
        return str.substring(0, Math.max(0, str.length() - 1));
    }

    @Override // com.google.android.gms.internal.zzxy, com.google.android.gms.internal.zzafv
    public final void onStop() {
        synchronized (this.zzckm) {
            super.onStop();
            if (this.zzckv != null) {
                this.zzckv.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzxy
    protected final void zzd(long j) throws zzyb {
        Bundle bundle;
        synchronized (this.zzckm) {
            this.zzckv = this.zzcbo.zzcbd != -1 ? new zzuu(this.mContext, this.zzckj.zzcrj, this.zzana, this.zzcbo, this.zzckk.zzbct, this.zzckk.zzbcv, this.zzckk.zzcqi, j, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbln)).longValue(), 2) : new zzux(this.mContext, this.zzckj.zzcrj, this.zzana, this.zzcbo, this.zzckk.zzbct, this.zzckk.zzbcv, this.zzckk.zzcqi, j, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbln)).longValue(), this.zzamn);
        }
        ArrayList arrayList = new ArrayList(this.zzcbo.zzcas);
        boolean z = false;
        Bundle bundle2 = this.zzckj.zzcrj.zzcnw.zzbbv;
        if (bundle2 != null && (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) != null) {
            z = bundle.getBoolean("_skipMediation");
        }
        if (z) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzuk) listIterator.next()).zzcac.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.zzckw = this.zzckv.zzg(arrayList);
        switch (this.zzckw.zzcbz) {
            case 0:
                if (this.zzckw.zzcca == null || this.zzckw.zzcca.zzcam == null) {
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                zzahf.zzdbo.post(new zzyj(this, countDownLatch));
                try {
                    countDownLatch.await(10L, TimeUnit.SECONDS);
                    synchronized (this.zzckm) {
                        if (!this.zzckx) {
                            throw new zzyb("View could not be prepared", 0);
                        }
                        if (this.zzbvz.isDestroyed()) {
                            throw new zzyb("Assets not loaded, web view is destroyed", 0);
                        }
                    }
                    return;
                } catch (InterruptedException e) {
                    String valueOf = String.valueOf(e);
                    throw new zzyb(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
                }
            case 1:
                throw new zzyb("No fill from any mediation ad networks.", 3);
            default:
                throw new zzyb(new StringBuilder(40).append("Unexpected mediation result: ").append(this.zzckw.zzcbz).toString(), 0);
        }
    }

    @Override // com.google.android.gms.internal.zzxy
    protected final zzafi zzx(int i) {
        zzaak zzaakVar = this.zzckj.zzcrj;
        return new zzafi(zzaakVar.zzcnw, this.zzbvz, this.zzckk.zzcau, i, this.zzckk.zzcav, this.zzckk.zzcpq, this.zzckk.orientation, this.zzckk.zzcba, zzaakVar.zzcnz, this.zzckk.zzcpo, this.zzckw != null ? this.zzckw.zzcca : null, this.zzckw != null ? this.zzckw.zzccb : null, this.zzckw != null ? this.zzckw.zzccc : AdMobAdapter.class.getName(), this.zzcbo, this.zzckw != null ? this.zzckw.zzccd : null, this.zzckk.zzcpp, this.zzckj.zzatn, this.zzckk.zzcpn, this.zzckj.zzcyi, this.zzckk.zzcps, this.zzckk.zzcpt, this.zzckj.zzcyc, null, this.zzckk.zzcqd, this.zzckk.zzcqe, this.zzckk.zzcqf, this.zzcbo != null ? this.zzcbo.zzcbf : false, this.zzckk.zzcqh, this.zzckv != null ? zzj(this.zzckv.zzli()) : null, this.zzckk.zzcax, this.zzckk.zzcqk, this.zzckj.zzcyo);
    }
}
