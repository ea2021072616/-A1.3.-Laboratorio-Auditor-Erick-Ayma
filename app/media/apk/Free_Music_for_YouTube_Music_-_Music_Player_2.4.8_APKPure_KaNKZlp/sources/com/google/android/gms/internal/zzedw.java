package com.google.android.gms.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public abstract class zzedw extends zzedj {
    private static final Logger logger = Logger.getLogger(zzedw.class.getName());
    private static final boolean zzmyg = zzefr.zzcdi();

    /* loaded from: classes2.dex */
    static class zza extends zzedw {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i | i2 | (bArr.length - (i + i2))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i + i2;
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zza(int i, zzedk zzedkVar) throws IOException {
            zzt(i, 2);
            zzah(zzedkVar);
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zza(int i, zzeey zzeeyVar) throws IOException {
            zzt(i, 2);
            zzd(zzeeyVar);
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzah(zzedk zzedkVar) throws IOException {
            zzgq(zzedkVar.size());
            zzedkVar.zza(this);
        }

        @Override // com.google.android.gms.internal.zzedj
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.zzedw
        public final int zzccc() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzcn(long j) throws IOException {
            if (zzedw.zzmyg && zzccc() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzefr.zza(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzefr.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzd(zzeey zzeeyVar) throws IOException {
            zzgq(zzeeyVar.zzbjo());
            zzeeyVar.zza(this);
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzgp(int i) throws IOException {
            if (i >= 0) {
                zzgq(i);
            } else {
                zzcn(i);
            }
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzgq(int i) throws IOException {
            if (zzedw.zzmyg && zzccc() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzefr.zza(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzefr.zza(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzl(int i, String str) throws IOException {
            zzt(1, 2);
            zzrb(str);
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzrb(String str) throws IOException {
            int i = this.position;
            try {
                int zzgt = zzgt(str.length() * 3);
                int zzgt2 = zzgt(str.length());
                if (zzgt2 == zzgt) {
                    this.position = i + zzgt2;
                    int zza = zzeft.zza(str, this.buffer, this.position, zzccc());
                    this.position = i;
                    zzgq((zza - i) - zzgt2);
                    this.position = zza;
                } else {
                    zzgq(zzeft.zzb(str));
                    this.position = zzeft.zza(str, this.buffer, this.position, zzccc());
                }
            } catch (zzefw e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzt(int i, int i2) throws IOException {
            zzgq((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.zzedw
        public final void zzu(int i, int i2) throws IOException {
            zzt(i, 0);
            zzgp(i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        zzb(java.lang.String r4, java.lang.Throwable r5) {
            /*
                r3 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r1 = java.lang.String.valueOf(r0)
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r2 = r0.length()
                if (r2 == 0) goto L18
                java.lang.String r0 = r1.concat(r0)
            L14:
                r3.<init>(r0, r5)
                return
            L18:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r1)
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzedw.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzedw() {
    }

    public static zzedw zzat(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzb(int i, zzedk zzedkVar) {
        int zzgr = zzgr(i);
        int size = zzedkVar.size();
        return zzgr + size + zzgt(size);
    }

    public static int zzb(int i, zzeey zzeeyVar) {
        int zzgr = zzgr(i);
        int zzbjo = zzeeyVar.zzbjo();
        return zzgr + zzbjo + zzgt(zzbjo);
    }

    private static int zzgr(int i) {
        return zzgt(i << 3);
    }

    private static int zzgs(int i) {
        if (i >= 0) {
            return zzgt(i);
        }
        return 10;
    }

    public static int zzgt(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public static int zzm(int i, String str) {
        return zzgr(1) + zzrc(str);
    }

    private static int zzrc(String str) {
        int length;
        try {
            length = zzeft.zzb(str);
        } catch (zzefw e) {
            length = str.getBytes(zzeen.UTF_8).length;
        }
        return length + zzgt(length);
    }

    public static int zzv(int i, int i2) {
        return zzgr(i) + zzgs(i2);
    }

    public static int zzw(int i, int i2) {
        return zzgr(i) + zzgs(i2);
    }

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, zzedk zzedkVar) throws IOException;

    public abstract void zza(int i, zzeey zzeeyVar) throws IOException;

    final void zza(String str, zzefw zzefwVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzefwVar);
        byte[] bytes = str.getBytes(zzeen.UTF_8);
        try {
            zzgq(bytes.length);
            zzb(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    public abstract void zzah(zzedk zzedkVar) throws IOException;

    public abstract int zzccc();

    public final void zzccd() {
        if (zzccc() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzcn(long j) throws IOException;

    public abstract void zzd(zzeey zzeeyVar) throws IOException;

    public abstract void zzgp(int i) throws IOException;

    public abstract void zzgq(int i) throws IOException;

    public abstract void zzl(int i, String str) throws IOException;

    public abstract void zzrb(String str) throws IOException;

    public abstract void zzt(int i, int i2) throws IOException;

    public abstract void zzu(int i, int i2) throws IOException;
}
