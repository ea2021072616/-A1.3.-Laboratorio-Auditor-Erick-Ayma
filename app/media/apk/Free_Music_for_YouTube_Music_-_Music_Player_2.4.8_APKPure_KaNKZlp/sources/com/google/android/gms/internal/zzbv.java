package com.google.android.gms.internal;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzbv {
    private static boolean zzyp = false;
    private static MessageDigest zzyq = null;
    private static final Object zzyr = new Object();
    private static final Object zzys = new Object();
    static CountDownLatch zzyt = new CountDownLatch(1);

    public static String zza(zzax zzaxVar, String str, boolean z) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] zza;
        byte[] zzc = zzego.zzc(zzaxVar);
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbma)).booleanValue()) {
            zza = z ? zza(zzc, str, true) : zza(zzc, str);
        } else if (zzby.zzyu == null) {
            throw new GeneralSecurityException();
        } else {
            byte[] zzd = zzby.zzyu.zzd(zzc, str != null ? str.getBytes() : new byte[0]);
            zzbe zzbeVar = new zzbe();
            zzbeVar.zzgj = new byte[][]{zzd};
            zzbeVar.zzgl = 2;
            zza = zzego.zzc(zzbeVar);
        }
        return zzbt.zza(zza, true);
    }

    public static String zza(String str, String str2, boolean z) {
        byte[] zza = zza(str, str2, true, ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblq)).booleanValue());
        return zza != null ? zzbt.zza(zza, true) : Integer.toString(7);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(String str, String str2, boolean z, boolean z2) {
        zzbb zzbbVar = new zzbb();
        try {
            zzbbVar.zzgc = str.length() < 3 ? str.getBytes("ISO-8859-1") : zzbt.zza(str, true);
            zzbbVar.zzgd = str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzbt.zza(str2, true);
            return zzego.zzc(zzbbVar);
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            return null;
        }
    }

    private static byte[] zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector<byte[]> zza = zza(bArr, 255);
        if (zza == null || zza.size() == 0) {
            return zza(zzego.zzc(zzb(4096L)), str, true);
        }
        zzbe zzbeVar = new zzbe();
        zzbeVar.zzgj = new byte[zza.size()];
        Iterator<byte[]> it = zza.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzbeVar.zzgj[i] = zza(it.next(), str, false);
            i++;
        }
        zzbeVar.zzge = zzb(bArr);
        return zzego.zzc(zzbeVar);
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zzego.zzc(zzb(4096L));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        new zzbz().zza(array, bArr3);
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzecf(str.getBytes(C.UTF8_NAME)).zzap(bArr3);
        }
        return bArr3;
    }

    private static zzax zzb(long j) {
        zzax zzaxVar = new zzax();
        zzaxVar.zzdq = 4096L;
        return zzaxVar;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzyr) {
            MessageDigest zzx = zzx();
            if (zzx == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzx.reset();
            zzx.update(bArr);
            digest = zzyq.digest();
        }
        return digest;
    }

    public static void zzw() {
        synchronized (zzys) {
            if (!zzyp) {
                zzyp = true;
                new Thread(new zzbx()).start();
            }
        }
    }

    private static MessageDigest zzx() {
        zzw();
        boolean z = false;
        try {
            z = zzyt.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        if (z && zzyq != null) {
            return zzyq;
        }
        return null;
    }
}
