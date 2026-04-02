package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.concurrent.Callable;
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class zzair<T> implements Callable<T> {
    private /* synthetic */ InputStream zzddj;
    private /* synthetic */ zzaip zzddk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzair(zzaip zzaipVar, InputStream inputStream) {
        this.zzddk = zzaipVar;
        this.zzddj = inputStream;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        zzaio zzaioVar;
        zzaioVar = this.zzddk.zzddg;
        return (T) zzaioVar.zzh(this.zzddj);
    }
}
