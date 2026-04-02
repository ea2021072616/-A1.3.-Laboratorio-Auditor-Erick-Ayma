package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
@zzzt
/* loaded from: classes.dex */
public final class zzafk {
    private final Object mLock;
    private final zzafn zzasi;
    private boolean zzcta;
    private final LinkedList<zzafl> zzcyq;
    private final String zzcyr;
    private final String zzcys;
    private long zzcyt;
    private long zzcyu;
    private long zzcyv;
    private long zzcyw;
    private long zzcyx;
    private long zzcyy;

    private zzafk(zzafn zzafnVar, String str, String str2) {
        this.mLock = new Object();
        this.zzcyt = -1L;
        this.zzcyu = -1L;
        this.zzcta = false;
        this.zzcyv = -1L;
        this.zzcyw = 0L;
        this.zzcyx = -1L;
        this.zzcyy = -1L;
        this.zzasi = zzafnVar;
        this.zzcyr = str;
        this.zzcys = str2;
        this.zzcyq = new LinkedList<>();
    }

    public zzafk(String str, String str2) {
        this(com.google.android.gms.ads.internal.zzbv.zzee(), str, str2);
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzcyr);
            bundle.putString("slotid", this.zzcys);
            bundle.putBoolean("ismediation", this.zzcta);
            bundle.putLong("treq", this.zzcyx);
            bundle.putLong("tresponse", this.zzcyy);
            bundle.putLong("timp", this.zzcyu);
            bundle.putLong("tload", this.zzcyv);
            bundle.putLong("pcc", this.zzcyw);
            bundle.putLong("tfetch", this.zzcyt);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzafl> it = this.zzcyq.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzh(long j) {
        synchronized (this.mLock) {
            this.zzcyy = j;
            if (this.zzcyy != -1) {
                this.zzasi.zza(this);
            }
        }
    }

    public final void zzi(long j) {
        synchronized (this.mLock) {
            if (this.zzcyy != -1) {
                this.zzcyt = j;
                this.zzasi.zza(this);
            }
        }
    }

    public final void zzo(zzix zzixVar) {
        synchronized (this.mLock) {
            this.zzcyx = SystemClock.elapsedRealtime();
            this.zzasi.zzps().zzb(zzixVar, this.zzcyx);
        }
    }

    public final void zzpf() {
        synchronized (this.mLock) {
            if (this.zzcyy != -1 && this.zzcyu == -1) {
                this.zzcyu = SystemClock.elapsedRealtime();
                this.zzasi.zza(this);
            }
            this.zzasi.zzps().zzpf();
        }
    }

    public final void zzpg() {
        synchronized (this.mLock) {
            if (this.zzcyy != -1) {
                zzafl zzaflVar = new zzafl();
                zzaflVar.zzpk();
                this.zzcyq.add(zzaflVar);
                this.zzcyw++;
                this.zzasi.zzps().zzpg();
                this.zzasi.zza(this);
            }
        }
    }

    public final void zzph() {
        synchronized (this.mLock) {
            if (this.zzcyy != -1 && !this.zzcyq.isEmpty()) {
                zzafl last = this.zzcyq.getLast();
                if (last.zzpi() == -1) {
                    last.zzpj();
                    this.zzasi.zza(this);
                }
            }
        }
    }

    public final void zzw(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcyy != -1) {
                this.zzcyv = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzcyu = this.zzcyv;
                    this.zzasi.zza(this);
                }
            }
        }
    }

    public final void zzx(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcyy != -1) {
                this.zzcta = z;
                this.zzasi.zza(this);
            }
        }
    }
}
