package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzajg extends Thread {
    private /* synthetic */ String zzbwj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajg(zzajf zzajfVar, String str) {
        this.zzbwj = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzajj().zzcm(this.zzbwj);
    }
}
