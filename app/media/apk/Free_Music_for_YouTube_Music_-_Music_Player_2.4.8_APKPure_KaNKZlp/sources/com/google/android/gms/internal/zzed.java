package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public abstract class zzed implements Callable {
    private String TAG = getClass().getSimpleName();
    private String className;
    protected final zzdc zzagk;
    protected final zzax zzajn;
    private String zzaju;
    protected Method zzajw;
    private int zzaka;
    private int zzakb;

    public zzed(zzdc zzdcVar, String str, String str2, zzax zzaxVar, int i, int i2) {
        this.zzagk = zzdcVar;
        this.className = str;
        this.zzaju = str2;
        this.zzajn = zzaxVar;
        this.zzaka = i;
        this.zzakb = i2;
    }

    protected abstract void zzar() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: zzat */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            this.zzajw = this.zzagk.zzc(this.className, this.zzaju);
            if (this.zzajw != null) {
                zzar();
                zzco zzai = this.zzagk.zzai();
                if (zzai != null && this.zzaka != Integer.MIN_VALUE) {
                    zzai.zza(this.zzakb, this.zzaka, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }
}
