package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
final class zzaen implements Runnable {
    private /* synthetic */ Bitmap val$bitmap;
    private /* synthetic */ zzaem zzcxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaen(zzaem zzaemVar, Bitmap bitmap) {
        this.zzcxf = zzaemVar;
        this.val$bitmap = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzegs zzegsVar;
        zzegs zzegsVar2;
        zzegs zzegsVar3;
        zzegs zzegsVar4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.val$bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        obj = this.zzcxf.mLock;
        synchronized (obj) {
            zzegsVar = this.zzcxf.zzcwx;
            zzegsVar.zzndw = new zzegz();
            zzegsVar2 = this.zzcxf.zzcwx;
            zzegsVar2.zzndw.zzner = byteArrayOutputStream.toByteArray();
            zzegsVar3 = this.zzcxf.zzcwx;
            zzegsVar3.zzndw.mimeType = "image/png";
            zzegsVar4 = this.zzcxf.zzcwx;
            zzegsVar4.zzndw.zzndp = 1;
        }
    }
}
