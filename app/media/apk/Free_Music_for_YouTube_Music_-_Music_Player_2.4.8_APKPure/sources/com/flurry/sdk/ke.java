package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public final class ke extends MessageDigest {

    /* renamed from: a  reason: collision with root package name */
    private CRC32 f2040a;

    public ke() {
        super("CRC");
        this.f2040a = new CRC32();
    }

    @Override // java.security.MessageDigestSpi
    protected final void engineUpdate(byte b2) {
        this.f2040a.update(b2);
    }

    @Override // java.security.MessageDigestSpi
    protected final void engineUpdate(byte[] bArr, int i, int i2) {
        this.f2040a.update(bArr, i, i2);
    }

    @Override // java.security.MessageDigestSpi
    protected final byte[] engineDigest() {
        long value = this.f2040a.getValue();
        return new byte[]{(byte) (((-16777216) & value) >> 24), (byte) ((16711680 & value) >> 16), (byte) ((65280 & value) >> 8), (byte) ((value & 255) >> 0)};
    }

    @Override // java.security.MessageDigestSpi
    protected final void engineReset() {
        this.f2040a.reset();
    }

    public final byte[] a() {
        return engineDigest();
    }

    public final int b() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }
}
