package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class ik {

    /* renamed from: a  reason: collision with root package name */
    long f1841a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1842b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f1843c;

    /* loaded from: classes.dex */
    public static class a implements lg<ik> {
        @Override // com.flurry.sdk.lg
        public final /* synthetic */ void a(OutputStream outputStream, ik ikVar) throws IOException {
            ik ikVar2 = ikVar;
            if (outputStream == null || ikVar2 == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ik.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            dataOutputStream.writeLong(ikVar2.f1841a);
            dataOutputStream.writeBoolean(ikVar2.f1842b);
            dataOutputStream.writeInt(ikVar2.f1843c.length);
            dataOutputStream.write(ikVar2.f1843c);
            dataOutputStream.flush();
        }

        @Override // com.flurry.sdk.lg
        public final /* synthetic */ ik a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ik.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            ik ikVar = new ik();
            ikVar.f1841a = dataInputStream.readLong();
            ikVar.f1842b = dataInputStream.readBoolean();
            ikVar.f1843c = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(ikVar.f1843c);
            return ikVar;
        }
    }
}
