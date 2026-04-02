package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class ja {

    /* renamed from: a  reason: collision with root package name */
    public String f1920a;

    /* renamed from: b  reason: collision with root package name */
    private int f1921b;

    /* renamed from: c  reason: collision with root package name */
    private long f1922c;
    private String d;
    private String e;
    private Throwable f;

    public ja(int i, long j, String str, String str2, String str3, Throwable th) {
        this.f1921b = i;
        this.f1922c = j;
        this.f1920a = str;
        this.d = str2;
        this.e = str3;
        this.f = th;
    }

    public final byte[] a() {
        Throwable th;
        DataOutputStream dataOutputStream;
        byte[] bArr;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeShort(this.f1921b);
                    dataOutputStream.writeLong(this.f1922c);
                    dataOutputStream.writeUTF(this.f1920a);
                    dataOutputStream.writeUTF(this.d);
                    dataOutputStream.writeUTF(this.e);
                    if (this.f != null) {
                        if ("uncaught".equals(this.f1920a)) {
                            dataOutputStream.writeByte(3);
                        } else {
                            dataOutputStream.writeByte(2);
                        }
                        dataOutputStream.writeByte(2);
                        StringBuilder sb = new StringBuilder("");
                        String property = System.getProperty("line.separator");
                        for (StackTraceElement stackTraceElement : this.f.getStackTrace()) {
                            sb.append(stackTraceElement);
                            sb.append(property);
                        }
                        if (this.f.getCause() != null) {
                            sb.append(property);
                            sb.append("Caused by: ");
                            for (StackTraceElement stackTraceElement2 : this.f.getCause().getStackTrace()) {
                                sb.append(stackTraceElement2);
                                sb.append(property);
                            }
                        }
                        byte[] bytes = sb.toString().getBytes();
                        dataOutputStream.writeInt(bytes.length);
                        dataOutputStream.write(bytes);
                    } else {
                        dataOutputStream.writeByte(1);
                        dataOutputStream.writeByte(0);
                    }
                    dataOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    ly.a(dataOutputStream);
                } catch (IOException e) {
                    bArr = new byte[0];
                    ly.a(dataOutputStream);
                    return bArr;
                }
            } catch (Throwable th2) {
                th = th2;
                ly.a((Closeable) null);
                throw th;
            }
        } catch (IOException e2) {
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            ly.a((Closeable) null);
            throw th;
        }
        return bArr;
    }
}
