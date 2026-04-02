package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class kq<ObjectType> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2074a = kq.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f2075b = {113, -92, -8, 125, 121, 107, -65, -61, -74, -114, -32, 0, -57, -87, -35, -56, -6, -52, 51, 126, -104, 49, 79, -52, 118, -84, 99, -52, -14, -126, -27, -64};

    /* renamed from: c  reason: collision with root package name */
    private String f2076c;
    private lg<ObjectType> d;

    public kq(String str, lg<ObjectType> lgVar) {
        this.f2076c = str;
        this.d = lgVar;
    }

    public static int a(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        ke keVar = new ke();
        keVar.update(bArr);
        return keVar.b();
    }

    public final byte[] a(ObjectType objecttype) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.d.a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        km.a(3, f2074a, "Encoding " + this.f2076c + ": " + new String(byteArray));
        le leVar = new le(new lc());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        leVar.a(byteArrayOutputStream2, byteArray);
        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
        c(byteArray2);
        return byteArray2;
    }

    private static void c(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int length2 = f2075b.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ f2075b[i % length2]) ^ ((i * 31) % 251));
            }
        }
    }

    public final ObjectType b(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IOException("Decoding: " + this.f2076c + ": Nothing to decode");
        }
        c(bArr);
        byte[] bArr2 = (byte[]) new le(new lc()).a(new ByteArrayInputStream(bArr));
        km.a(3, f2074a, "Decoding: " + this.f2076c + ": " + new String(bArr2));
        return this.d.a(new ByteArrayInputStream(bArr2));
    }
}
