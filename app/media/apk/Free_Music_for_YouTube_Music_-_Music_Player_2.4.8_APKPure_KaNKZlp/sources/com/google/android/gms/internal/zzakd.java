package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
@zzzt
/* loaded from: classes.dex */
public class zzakd<T> implements zzajz<T> {
    private final Object mLock = new Object();
    private int zzbyx = 0;
    private BlockingQueue<zzake> zzdfg = new LinkedBlockingQueue();
    private T zzdfh;

    public int getStatus() {
        return this.zzbyx;
    }

    public void reject() {
        synchronized (this.mLock) {
            if (this.zzbyx != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzbyx = -1;
            for (zzake zzakeVar : this.zzdfg) {
                zzakeVar.zzdfj.run();
            }
            this.zzdfg.clear();
        }
    }

    @Override // com.google.android.gms.internal.zzajz
    public void zza(zzakc<T> zzakcVar, zzaka zzakaVar) {
        synchronized (this.mLock) {
            if (this.zzbyx == 1) {
                zzakcVar.zzc(this.zzdfh);
            } else if (this.zzbyx == -1) {
                zzakaVar.run();
            } else if (this.zzbyx == 0) {
                this.zzdfg.add(new zzake(this, zzakcVar, zzakaVar));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzajz
    public void zzf(T t) {
        synchronized (this.mLock) {
            if (this.zzbyx != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzdfh = t;
            this.zzbyx = 1;
            for (zzake zzakeVar : this.zzdfg) {
                zzakeVar.zzdfi.zzc(t);
            }
            this.zzdfg.clear();
        }
    }
}
