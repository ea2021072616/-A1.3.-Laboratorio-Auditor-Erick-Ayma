package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class zzcx {
    private static Cipher zzahw = null;
    private static final Object zzahx = new Object();
    private static final Object zzahy = new Object();
    private final SecureRandom zzahv = null;

    public zzcx(SecureRandom secureRandom) {
    }

    private static Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (zzahy) {
            if (zzahw == null) {
                zzahw = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzahw;
        }
        return cipher;
    }

    public final byte[] zzb(byte[] bArr, String str) throws zzcy {
        byte[] doFinal;
        if (bArr.length != 16) {
            throw new zzcy(this);
        }
        try {
            byte[] zza = zzbt.zza(str, false);
            if (zza.length <= 16) {
                throw new zzcy(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza.length);
            allocate.put(zza);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[zza.length - 16];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzahx) {
                getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                doFinal = getCipher().doFinal(bArr3);
            }
            return doFinal;
        } catch (IllegalArgumentException e) {
            throw new zzcy(this, e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zzcy(this, e2);
        } catch (InvalidKeyException e3) {
            throw new zzcy(this, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zzcy(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzcy(this, e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zzcy(this, e6);
        } catch (NoSuchPaddingException e7) {
            throw new zzcy(this, e7);
        }
    }

    public final String zzc(byte[] bArr, byte[] bArr2) throws zzcy {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzcy(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzahx) {
                getCipher().init(1, secretKeySpec, (SecureRandom) null);
                doFinal = getCipher().doFinal(bArr2);
                iv = getCipher().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length];
            allocate.get(bArr3);
            return zzbt.zza(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zzcy(this, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zzcy(this, e2);
        } catch (BadPaddingException e3) {
            throw new zzcy(this, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zzcy(this, e4);
        } catch (NoSuchPaddingException e5) {
            throw new zzcy(this, e5);
        }
    }

    public final byte[] zzl(String str) throws zzcy {
        try {
            byte[] zza = zzbt.zza(str, false);
            if (zza.length != 32) {
                throw new zzcy(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zzcy(this, e);
        }
    }
}
