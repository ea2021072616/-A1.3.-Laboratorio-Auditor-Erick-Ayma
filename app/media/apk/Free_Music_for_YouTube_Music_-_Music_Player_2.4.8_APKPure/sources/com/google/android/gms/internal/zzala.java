package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzala implements Runnable {
    private /* synthetic */ zzaky zzdhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzala(zzaky zzakyVar) {
        this.zzdhr = zzakyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
