package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public abstract class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f1953a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f1954b;

    static {
        Charset.forName("US-ASCII");
        f1953a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1954b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
