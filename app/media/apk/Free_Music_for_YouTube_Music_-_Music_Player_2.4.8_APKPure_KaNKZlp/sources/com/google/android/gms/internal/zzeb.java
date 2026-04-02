package com.google.android.gms.internal;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class zzeb {
    private static String TAG = zzeb.class.getSimpleName();
    private final String className;
    private final zzdc zzagk;
    private final String zzaju;
    private final Class<?>[] zzajx;
    private final int zzajv = 2;
    private volatile Method zzajw = null;
    private CountDownLatch zzajy = new CountDownLatch(1);

    public zzeb(zzdc zzdcVar, String str, String str2, Class<?>... clsArr) {
        this.zzagk = zzdcVar;
        this.className = str;
        this.zzaju = str2;
        this.zzajx = clsArr;
        this.zzagk.zzad().submit(new zzec(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzav() {
        try {
            Class loadClass = this.zzagk.zzae().loadClass(zzc(this.zzagk.zzag(), this.className));
            if (loadClass == null) {
                return;
            }
            this.zzajw = loadClass.getMethod(zzc(this.zzagk.zzag(), this.zzaju), this.zzajx);
            if (this.zzajw == null) {
            }
        } catch (zzcy e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.zzajy.countDown();
        }
    }

    private final String zzc(byte[] bArr, String str) throws zzcy, UnsupportedEncodingException {
        return new String(this.zzagk.zzaf().zzb(bArr, str), C.UTF8_NAME);
    }

    public final Method zzaw() {
        if (this.zzajw != null) {
            return this.zzajw;
        }
        try {
            if (this.zzajy.await(2L, TimeUnit.SECONDS)) {
                return this.zzajw;
            }
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
