package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyz implements zzaio<zznv> {
    private /* synthetic */ String zzceh;
    private /* synthetic */ zzys zzcly;
    private /* synthetic */ boolean zzcmm;
    private /* synthetic */ double zzcmn;
    private /* synthetic */ boolean zzcmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyz(zzys zzysVar, boolean z, double d, boolean z2, String str) {
        this.zzcly = zzysVar;
        this.zzcmm = z;
        this.zzcmn = d;
        this.zzcmo = z2;
        this.zzceh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzaio
    @TargetApi(19)
    /* renamed from: zzg */
    public final zznv zzh(InputStream inputStream) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (160.0d * this.zzcmn);
        if (!this.zzcmo) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception e) {
            zzafx.zzb("Error grabbing image.", e);
            bitmap = null;
        }
        if (bitmap == null) {
            this.zzcly.zzd(2, this.zzcmm);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (com.google.android.gms.common.util.zzp.zzalh() && zzafx.zzqr()) {
            int width = bitmap.getWidth();
            zzafx.v(new StringBuilder(108).append("Decoded image w: ").append(width).append(" h:").append(bitmap.getHeight()).append(" bytes: ").append(bitmap.getAllocationByteCount()).append(" time: ").append(uptimeMillis2 - uptimeMillis).append(" on ui thread: ").append(Looper.getMainLooper().getThread() == Thread.currentThread()).toString());
        }
        return new zznv(new BitmapDrawable(Resources.getSystem(), bitmap), Uri.parse(this.zzceh), this.zzcmn);
    }

    @Override // com.google.android.gms.internal.zzaio
    public final /* synthetic */ zznv zzob() {
        this.zzcly.zzd(2, this.zzcmm);
        return null;
    }
}
