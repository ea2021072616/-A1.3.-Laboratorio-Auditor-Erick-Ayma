package com.google.android.gms.internal;

import com.flurry.android.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
final class zzefr {
    private static final boolean zzmyg;
    private static final boolean zznan;
    private static final boolean zznao;
    private static final boolean zznap;
    private static final zzd zznaq;
    private static final boolean zznar;
    private static final boolean zznas;
    private static final long zznat;
    private static final long zznau;
    private static final long zznav;
    private static final long zznaw;
    private static final long zznax;
    private static final long zznay;
    private static final long zznaz;
    private static final long zznba;
    private static final long zznbb;
    private static final long zznbc;
    private static final long zznbd;
    private static final long zznbe;
    private static final long zznbf;
    private static final long zznbg;
    private static final boolean zznbh;
    private static final Logger logger = Logger.getLogger(zzefr.class.getName());
    private static final Unsafe zznal = zzcdk();
    private static final Class<?> zznam = zzre("libcore.io.Memory");

    /* loaded from: classes2.dex */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.zzefr.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzefr.zznbh) {
                zzefr.zza(obj, j, b2);
            } else {
                zzefr.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.zzefr.zzd
        public final byte zzf(Object obj, long j) {
            return zzefr.zznbh ? zzefr.zzb(obj, j) : zzefr.zzc(obj, j);
        }
    }

    /* loaded from: classes2.dex */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.zzefr.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzefr.zznbh) {
                zzefr.zza(obj, j, b2);
            } else {
                zzefr.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.zzefr.zzd
        public final byte zzf(Object obj, long j) {
            return zzefr.zznbh ? zzefr.zzb(obj, j) : zzefr.zzc(obj, j);
        }
    }

    /* loaded from: classes2.dex */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.zzefr.zzd
        public final void zze(Object obj, long j, byte b2) {
            this.zznbi.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.zzefr.zzd
        public final byte zzf(Object obj, long j) {
            return this.zznbi.getByte(obj, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class zzd {
        Unsafe zznbi;

        zzd(Unsafe unsafe) {
            this.zznbi = unsafe;
        }

        public abstract void zze(Object obj, long j, byte b2);

        public abstract byte zzf(Object obj, long j);
    }

    static {
        Field zza2;
        zznan = zzre("org.robolectric.Robolectric") != null;
        zznao = zzi(Long.TYPE);
        zznap = zzi(Integer.TYPE);
        zznaq = zznal == null ? null : zzcdo() ? zznao ? new zzb(zznal) : zznap ? new zza(zznal) : null : new zzc(zznal);
        zznar = zzcdn();
        zzmyg = zzcdl();
        zznas = zzcdm();
        zznat = zzg(byte[].class);
        zznau = zzg(boolean[].class);
        zznav = zzh(boolean[].class);
        zznaw = zzg(int[].class);
        zznax = zzh(int[].class);
        zznay = zzg(long[].class);
        zznaz = zzh(long[].class);
        zznba = zzg(float[].class);
        zznbb = zzh(float[].class);
        zznbc = zzg(double[].class);
        zznbd = zzh(double[].class);
        zznbe = zzg(Object[].class);
        zznbf = zzh(Object[].class);
        if (!zzcdo() || (zza2 = zza(Buffer.class, "effectiveDirectAddress")) == null) {
            zza2 = zza(Buffer.class, "address");
        }
        zznbg = (zza2 == null || zznaq == null) ? -1L : zznaq.zznbi.objectFieldOffset(zza2);
        zznbh = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzefr() {
    }

    private static int zza(Object obj, long j) {
        return zznaq.zznbi.getInt(obj, j);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zza(obj, j & (-4), (zza(obj, j & (-4)) & ((255 << i) ^ (-1))) | ((b2 & Constants.UNKNOWN) << i));
    }

    private static void zza(Object obj, long j, int i) {
        zznaq.zznbi.putInt(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j, byte b2) {
        zznaq.zze(bArr, zznat + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzb(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) ((((-1) ^ j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zzb(byte[] bArr, long j) {
        return zznaq.zzf(bArr, zznat + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        int i = (((int) j) & 3) << 3;
        zza(obj, j & (-4), (zza(obj, j & (-4)) & ((255 << i) ^ (-1))) | ((b2 & Constants.UNKNOWN) << i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzc(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) ((3 & j) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzcdi() {
        return zzmyg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzcdj() {
        return zznar;
    }

    private static Unsafe zzcdk() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzefs());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzcdl() {
        if (zznal == null) {
            return false;
        }
        try {
            Class<?> cls = zznal.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzcdo()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzcdm() {
        if (zznal == null) {
            return false;
        }
        try {
            zznal.getClass().getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeCopyMemory", "copyMemory is missing from platform - proto runtime falling back to safer methods.");
            return false;
        }
    }

    private static boolean zzcdn() {
        if (zznal == null) {
            return false;
        }
        try {
            Class<?> cls = zznal.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzcdo()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzcdo() {
        return (zznam == null || zznan) ? false : true;
    }

    private static int zzg(Class<?> cls) {
        if (zzmyg) {
            return zznaq.zznbi.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzmyg) {
            return zznaq.zznbi.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        if (zzcdo()) {
            try {
                Class<?> cls2 = zznam;
                cls2.getMethod("peekLong", cls, Boolean.TYPE);
                cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
                cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
                cls2.getMethod("peekInt", cls, Boolean.TYPE);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private static <T> Class<T> zzre(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
