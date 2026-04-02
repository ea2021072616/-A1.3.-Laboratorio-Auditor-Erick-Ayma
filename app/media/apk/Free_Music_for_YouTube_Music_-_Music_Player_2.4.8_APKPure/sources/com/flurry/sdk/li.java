package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class li<T> implements lg<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f2144a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2145b;

    /* renamed from: c  reason: collision with root package name */
    private final lj<T> f2146c;

    public li(String str, int i, lj<T> ljVar) {
        this.f2144a = str;
        this.f2145b = i;
        this.f2146c = ljVar;
    }

    @Override // com.flurry.sdk.lg
    public final void a(OutputStream outputStream, T t) throws IOException {
        if (outputStream != null && this.f2146c != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.li.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            dataOutputStream.writeUTF(this.f2144a);
            dataOutputStream.writeInt(this.f2145b);
            this.f2146c.a(this.f2145b).a(dataOutputStream, t);
            dataOutputStream.flush();
        }
    }

    @Override // com.flurry.sdk.lg
    public final T a(InputStream inputStream) throws IOException {
        if (inputStream == null || this.f2146c == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.li.2
            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        };
        String readUTF = dataInputStream.readUTF();
        if (!this.f2144a.equals(readUTF)) {
            throw new IOException("Signature: " + readUTF + " is invalid");
        }
        return this.f2146c.a(dataInputStream.readInt()).a(dataInputStream);
    }
}
