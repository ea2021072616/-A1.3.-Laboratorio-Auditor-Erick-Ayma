package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import b.a.a.a.a.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzaec extends zzafv implements zzaeb {
    private final Context mContext;
    private final Object mLock;
    private final zzafj zzckj;
    private final long zzcwc;
    private final ArrayList<Future> zzcwn;
    private final ArrayList<String> zzcwo;
    private final HashMap<String, zzads> zzcwp;
    private final List<zzadv> zzcwq;
    private final HashSet<String> zzcwr;
    private final zzacy zzcws;

    public zzaec(Context context, zzafj zzafjVar, zzacy zzacyVar) {
        this(context, zzafjVar, zzacyVar, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjk)).longValue());
    }

    private zzaec(Context context, zzafj zzafjVar, zzacy zzacyVar, long j) {
        this.zzcwn = new ArrayList<>();
        this.zzcwo = new ArrayList<>();
        this.zzcwp = new HashMap<>();
        this.zzcwq = new ArrayList();
        this.zzcwr = new HashSet<>();
        this.mLock = new Object();
        this.mContext = context;
        this.zzckj = zzafjVar;
        this.zzcws = zzacyVar;
        this.zzcwc = j;
    }

    private final zzafi zza(int i, @Nullable String str, @Nullable zzuk zzukVar) {
        return new zzafi(this.zzckj.zzcrj.zzcnw, null, this.zzckj.zzcyp.zzcau, i, this.zzckj.zzcyp.zzcav, this.zzckj.zzcyp.zzcpq, this.zzckj.zzcyp.orientation, this.zzckj.zzcyp.zzcba, this.zzckj.zzcrj.zzcnz, this.zzckj.zzcyp.zzcpo, zzukVar, null, str, this.zzckj.zzcye, null, this.zzckj.zzcyp.zzcpp, this.zzckj.zzatn, this.zzckj.zzcyp.zzcpn, this.zzckj.zzcyi, this.zzckj.zzcyp.zzcps, this.zzckj.zzcyp.zzcpt, this.zzckj.zzcyc, null, this.zzckj.zzcyp.zzcqd, this.zzckj.zzcyp.zzcqe, this.zzckj.zzcyp.zzcqf, this.zzckj.zzcyp.zzcqg, this.zzckj.zzcyp.zzcqh, zzoy(), this.zzckj.zzcyp.zzcax, this.zzckj.zzcyp.zzcqk, this.zzckj.zzcyo);
    }

    private final String zzoy() {
        int i;
        StringBuilder sb = new StringBuilder("");
        if (this.zzcwq == null) {
            return sb.toString();
        }
        for (zzadv zzadvVar : this.zzcwq) {
            if (zzadvVar != null && !TextUtils.isEmpty(zzadvVar.zzcad)) {
                String str = zzadvVar.zzcad;
                switch (zzadvVar.errorCode) {
                    case 3:
                        i = 1;
                        break;
                    case 4:
                        i = 2;
                        break;
                    case 5:
                        i = 4;
                        break;
                    case 6:
                        i = 0;
                        break;
                    case 7:
                        i = 3;
                        break;
                    default:
                        i = 6;
                        break;
                }
                sb.append(String.valueOf(new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(i).append(".").append(zzadvVar.zzccf).toString()).concat(b.ROLL_OVER_FILE_NAME_SEPARATOR));
            }
        }
        return sb.substring(0, Math.max(0, sb.length() - 1));
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzaeb
    public final void zza(String str, int i) {
    }

    @Override // com.google.android.gms.internal.zzaeb
    public final void zzbv(String str) {
        synchronized (this.mLock) {
            this.zzcwr.add(str);
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        zzads zzadsVar;
        zzads zzadsVar2;
        zzads zzadsVar3;
        zzads zzadsVar4;
        String string;
        for (zzuk zzukVar : this.zzckj.zzcye.zzcas) {
            String str = zzukVar.zzcaj;
            for (String str2 : zzukVar.zzcac) {
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str2) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
                    try {
                        string = new JSONObject(str).getString("class_name");
                    } catch (JSONException e) {
                        zzafx.zzb("Unable to determine custom event class name, skipping...", e);
                    }
                } else {
                    string = str2;
                }
                synchronized (this.mLock) {
                    zzaef zzbu = this.zzcws.zzbu(string);
                    if (zzbu == null || zzbu.zzpa() == null || zzbu.zzoz() == null) {
                        this.zzcwq.add(new zzadx().zzbx(zzukVar.zzcad).zzbw(string).zzg(0L).zzaa(7).zzox());
                    } else {
                        zzads zzadsVar5 = new zzads(this.mContext, string, str, zzukVar, this.zzckj, zzbu, this, this.zzcwc);
                        this.zzcwn.add((Future) zzadsVar5.zzns());
                        this.zzcwo.add(string);
                        this.zzcwp.put(string, zzadsVar5);
                    }
                }
            }
        }
        for (int i = 0; i < this.zzcwn.size(); i++) {
            try {
                try {
                    this.zzcwn.get(i).get();
                    synchronized (this.mLock) {
                        String str3 = this.zzcwo.get(i);
                        if (!TextUtils.isEmpty(str3) && (zzadsVar4 = this.zzcwp.get(str3)) != null) {
                            this.zzcwq.add(zzadsVar4.zzou());
                        }
                    }
                    synchronized (this.mLock) {
                        if (this.zzcwr.contains(this.zzcwo.get(i))) {
                            String str4 = this.zzcwo.get(i);
                            zzaje.zzdee.post(new zzaed(this, zza(-2, str4, this.zzcwp.get(str4) != null ? this.zzcwp.get(str4).zzov() : null)));
                            return;
                        }
                    }
                    continue;
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        String str5 = this.zzcwo.get(i);
                        if (!TextUtils.isEmpty(str5) && (zzadsVar3 = this.zzcwp.get(str5)) != null) {
                            this.zzcwq.add(zzadsVar3.zzou());
                        }
                        throw th;
                    }
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                synchronized (this.mLock) {
                    String str6 = this.zzcwo.get(i);
                    if (!TextUtils.isEmpty(str6) && (zzadsVar2 = this.zzcwp.get(str6)) != null) {
                        this.zzcwq.add(zzadsVar2.zzou());
                    }
                }
            } catch (Exception e3) {
                zzafx.zzc("Unable to resolve rewarded adapter.", e3);
                synchronized (this.mLock) {
                    String str7 = this.zzcwo.get(i);
                    if (!TextUtils.isEmpty(str7) && (zzadsVar = this.zzcwp.get(str7)) != null) {
                        this.zzcwq.add(zzadsVar.zzou());
                    }
                    continue;
                }
            }
        }
        zzaje.zzdee.post(new zzaee(this, zza(3, null, null)));
    }
}
