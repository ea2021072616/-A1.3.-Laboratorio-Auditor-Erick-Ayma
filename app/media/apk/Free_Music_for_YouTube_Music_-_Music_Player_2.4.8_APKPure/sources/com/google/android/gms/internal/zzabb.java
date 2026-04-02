package com.google.android.gms.internal;

import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabb implements Runnable {
    private /* synthetic */ OutputStream zzcqs;
    private /* synthetic */ byte[] zzcqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabb(zzaba zzabaVar, OutputStream outputStream, byte[] bArr) {
        this.zzcqs = outputStream;
        this.zzcqt = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            r2 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L33
            java.io.OutputStream r0 = r4.zzcqs     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L33
            r1.<init>(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L33
            byte[] r0 = r4.zzcqt     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            int r0 = r0.length     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            r1.writeInt(r0)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            byte[] r0 = r4.zzcqt     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            r1.write(r0)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            com.google.android.gms.common.util.zzm.closeQuietly(r1)
        L16:
            return
        L17:
            r0 = move-exception
            r1 = r2
        L19:
            java.lang.String r2 = "Error transporting the ad response"
            com.google.android.gms.internal.zzafx.zzb(r2, r0)     // Catch: java.lang.Throwable -> L41
            com.google.android.gms.internal.zzafn r2 = com.google.android.gms.ads.internal.zzbv.zzee()     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "LargeParcelTeleporter.pipeData.1"
            r2.zza(r0, r3)     // Catch: java.lang.Throwable -> L41
            if (r1 != 0) goto L2f
            java.io.OutputStream r0 = r4.zzcqs
            com.google.android.gms.common.util.zzm.closeQuietly(r0)
            goto L16
        L2f:
            com.google.android.gms.common.util.zzm.closeQuietly(r1)
            goto L16
        L33:
            r0 = move-exception
            r1 = r2
        L35:
            if (r1 != 0) goto L3d
            java.io.OutputStream r1 = r4.zzcqs
            com.google.android.gms.common.util.zzm.closeQuietly(r1)
        L3c:
            throw r0
        L3d:
            com.google.android.gms.common.util.zzm.closeQuietly(r1)
            goto L3c
        L41:
            r0 = move-exception
            goto L35
        L43:
            r0 = move-exception
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabb.run():void");
    }
}
