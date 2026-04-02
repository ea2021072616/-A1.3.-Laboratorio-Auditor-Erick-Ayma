package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
/* loaded from: classes.dex */
public final class kz {

    /* renamed from: a  reason: collision with root package name */
    String f2123a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f2124b;

    /* synthetic */ kz(byte b2) {
        this();
    }

    private kz() {
        this.f2123a = null;
        this.f2124b = null;
    }

    public kz(byte[] bArr) {
        this.f2123a = null;
        this.f2124b = null;
        this.f2123a = UUID.randomUUID().toString();
        this.f2124b = bArr;
    }

    public static String a(String str) {
        return ".yflurrydatasenderblock." + str;
    }

    /* loaded from: classes.dex */
    public static class a implements lg<kz> {
        @Override // com.flurry.sdk.lg
        public final /* synthetic */ void a(OutputStream outputStream, kz kzVar) throws IOException {
            kz kzVar2 = kzVar;
            if (outputStream == null || kzVar2 == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.kz.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            dataOutputStream.writeShort(kzVar2.f2124b.length);
            dataOutputStream.write(kzVar2.f2124b);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
        }

        @Override // com.flurry.sdk.lg
        public final /* synthetic */ kz a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.kz.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            kz kzVar = new kz((byte) 0);
            int readShort = dataInputStream.readShort();
            if (readShort != 0) {
                kzVar.f2124b = new byte[readShort];
                dataInputStream.readFully(kzVar.f2124b);
                dataInputStream.readUnsignedShort();
                return kzVar;
            }
            return null;
        }
    }
}
