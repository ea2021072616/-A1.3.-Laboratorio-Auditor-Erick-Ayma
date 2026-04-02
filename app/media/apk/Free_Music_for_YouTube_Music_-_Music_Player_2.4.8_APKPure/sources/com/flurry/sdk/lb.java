package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class lb {

    /* renamed from: a  reason: collision with root package name */
    String f2137a;

    /* synthetic */ lb(byte b2) {
        this();
    }

    private lb() {
    }

    public lb(String str) {
        this.f2137a = str;
    }

    /* loaded from: classes.dex */
    public static class a implements lg<lb> {
        @Override // com.flurry.sdk.lg
        public final /* synthetic */ void a(OutputStream outputStream, lb lbVar) throws IOException {
            lb lbVar2 = lbVar;
            if (outputStream == null || lbVar2 == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.lb.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            dataOutputStream.writeUTF(lbVar2.f2137a);
            dataOutputStream.flush();
        }

        @Override // com.flurry.sdk.lg
        public final /* synthetic */ lb a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.lb.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            lb lbVar = new lb((byte) 0);
            lbVar.f2137a = dataInputStream.readUTF();
            return lbVar;
        }
    }
}
