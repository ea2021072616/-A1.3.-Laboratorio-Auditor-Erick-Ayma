package com.google.android.gms.internal;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class zzeen {
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static ByteBuffer zzmzm;
    private static zzedt zzmzn;
    static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);
    private static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        zzmzm = ByteBuffer.wrap(bArr);
        zzmzn = zzedt.zzas(EMPTY_BYTE_ARRAY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzu(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
}
