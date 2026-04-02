package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzaeo implements Runnable {
    private /* synthetic */ zzaem zzcxf;
    private /* synthetic */ zzajr zzcxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeo(zzaem zzaemVar, zzajr zzajrVar) {
        this.zzcxf = zzaemVar;
        this.zzcxg = zzajrVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            com.google.android.gms.internal.zzajr r0 = r4.zzcxg     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            java.lang.Object r0 = r0.get()     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            java.util.Map r0 = (java.util.Map) r0     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            com.google.android.gms.internal.zzaem r1 = r4.zzcxf     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            r1.zzj(r0)     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            com.google.android.gms.internal.zzaem r0 = r4.zzcxf     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            boolean r0 = r0.zzcxa     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            if (r0 == 0) goto L29
            com.google.android.gms.internal.zzaem r0 = r4.zzcxf     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            java.lang.Object r1 = com.google.android.gms.internal.zzaem.zza(r0)     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            monitor-enter(r1)     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            com.google.android.gms.internal.zzaem r0 = r4.zzcxf     // Catch: java.lang.Throwable -> L2f
            com.google.android.gms.internal.zzegs r0 = com.google.android.gms.internal.zzaem.zzb(r0)     // Catch: java.lang.Throwable -> L2f
            r2 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L2f
            r0.zzndp = r2     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2f
        L29:
            com.google.android.gms.internal.zzaem r0 = r4.zzcxf     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
            r0.send()     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
        L2e:
            return
        L2f:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2f
            throw r0     // Catch: java.lang.InterruptedException -> L32 java.util.concurrent.ExecutionException -> L4c org.json.JSONException -> L4f
        L32:
            r0 = move-exception
            r1 = r0
        L34:
            java.lang.String r2 = "Failed to get SafeBrowsing metadata"
            com.google.android.gms.internal.zzmk<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmu.zzbog
            com.google.android.gms.internal.zzms r3 = com.google.android.gms.ads.internal.zzbv.zzen()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L2e
            com.google.android.gms.internal.zzafx.zza(r2, r1)
            goto L2e
        L4c:
            r0 = move-exception
            r1 = r0
            goto L34
        L4f:
            r0 = move-exception
            r1 = r0
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaeo.run():void");
    }
}
