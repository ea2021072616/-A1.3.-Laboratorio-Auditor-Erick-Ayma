package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzub {
    final String zzapb;
    final zzix zzari;
    final int zzbxm;

    private zzub(zzix zzixVar, String str, int i) {
        this.zzari = zzixVar;
        this.zzapb = str;
        this.zzbxm = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzub(zztx zztxVar) {
        this(zztxVar.zzkk(), zztxVar.getAdUnitId(), zztxVar.getNetworkType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzub zzbb(String str) throws IOException {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                String str2 = new String(Base64.decode(split[0], 0), C.UTF8_NAME);
                int parseInt = Integer.parseInt(split[1]);
                byte[] decode = Base64.decode(split[2], 0);
                obtain.unmarshall(decode, 0, decode.length);
                obtain.setDataPosition(0);
                return new zzub(zzix.CREATOR.createFromParcel(obtain), str2, parseInt);
            } finally {
                obtain.recycle();
            }
        } catch (com.google.android.gms.common.internal.safeparcel.zzc | IllegalArgumentException | IllegalStateException e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "QueueSeed.decode");
            throw new IOException("Malformed QueueSeed encoding.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzky() {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                String encodeToString = Base64.encodeToString(this.zzapb.getBytes(C.UTF8_NAME), 0);
                String num = Integer.toString(this.zzbxm);
                this.zzari.writeToParcel(obtain, 0);
                String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
                String sb = new StringBuilder(String.valueOf(encodeToString).length() + 2 + String.valueOf(num).length() + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
                obtain.recycle();
                return sb;
            } catch (UnsupportedEncodingException e) {
                zzafx.e("QueueSeed encode failed because UTF-8 is not available.");
                obtain.recycle();
                return "";
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }
}
