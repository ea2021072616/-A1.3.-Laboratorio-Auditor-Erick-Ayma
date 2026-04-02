package com.flurry.sdk;

import com.flurry.sdk.iq;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ip extends kw {
    private static final String t = ip.class.getName();

    /* renamed from: a  reason: collision with root package name */
    final long f1873a;

    /* renamed from: b  reason: collision with root package name */
    final int f1874b;

    /* renamed from: c  reason: collision with root package name */
    final int f1875c;
    final iw d;
    final Map<String, String> e;
    public ArrayList<iq> f;
    public it g;
    long h;
    int i;
    int j;
    String k;
    String l;
    boolean m;

    public ip(String str, long j, String str2, long j2, int i, int i2, iw iwVar, Map<String, String> map, int i3, int i4, String str3) {
        a(str2);
        this.n = j2;
        a_();
        this.l = str;
        this.f1873a = j;
        this.s = i;
        this.f1874b = i;
        this.f1875c = i2;
        this.d = iwVar;
        this.e = map;
        this.i = i3;
        this.j = i4;
        this.k = str3;
        this.h = 30000L;
        this.f = new ArrayList<>();
    }

    @Override // com.flurry.sdk.kw
    public final void a_() {
        super.a_();
        if (this.p != 1) {
            this.h *= 3;
        }
    }

    public final synchronized void c() {
        this.g.c();
    }

    public final void d() {
        Iterator<iq> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().l = this;
        }
    }

    /* loaded from: classes.dex */
    public static class a implements lg<ip> {

        /* renamed from: a  reason: collision with root package name */
        lf<iq> f1876a = new lf<>(new iq.a());

        @Override // com.flurry.sdk.lg
        public final /* synthetic */ void a(OutputStream outputStream, ip ipVar) throws IOException {
            ip ipVar2 = ipVar;
            if (outputStream == null || ipVar2 == null) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.ip.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            if (ipVar2.l != null) {
                dataOutputStream.writeUTF(ipVar2.l);
            } else {
                dataOutputStream.writeUTF("");
            }
            if (ipVar2.r != null) {
                dataOutputStream.writeUTF(ipVar2.r);
            } else {
                dataOutputStream.writeUTF("");
            }
            dataOutputStream.writeLong(ipVar2.n);
            dataOutputStream.writeInt(ipVar2.p);
            dataOutputStream.writeLong(ipVar2.f1873a);
            dataOutputStream.writeInt(ipVar2.f1874b);
            dataOutputStream.writeInt(ipVar2.f1875c);
            dataOutputStream.writeInt(ipVar2.d.e);
            Map map = ipVar2.e;
            if (map != null) {
                dataOutputStream.writeInt(ipVar2.e.size());
                for (String str : ipVar2.e.keySet()) {
                    dataOutputStream.writeUTF(str);
                    dataOutputStream.writeUTF((String) map.get(str));
                }
            } else {
                dataOutputStream.writeInt(0);
            }
            dataOutputStream.writeLong(ipVar2.h);
            dataOutputStream.writeInt(ipVar2.i);
            dataOutputStream.writeInt(ipVar2.j);
            if (ipVar2.k != null) {
                dataOutputStream.writeUTF(ipVar2.k);
            } else {
                dataOutputStream.writeUTF("");
            }
            dataOutputStream.writeBoolean(ipVar2.m);
            dataOutputStream.flush();
            this.f1876a.a(outputStream, (List<iq>) ipVar2.f);
        }

        @Override // com.flurry.sdk.lg
        public final /* synthetic */ ip a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream) { // from class: com.flurry.sdk.ip.a.2
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            String readUTF = dataInputStream.readUTF();
            if (readUTF.equals("")) {
                readUTF = null;
            }
            String readUTF2 = dataInputStream.readUTF();
            long readLong = dataInputStream.readLong();
            int readInt = dataInputStream.readInt();
            long readLong2 = dataInputStream.readLong();
            int readInt2 = dataInputStream.readInt();
            int readInt3 = dataInputStream.readInt();
            iw a2 = iw.a(dataInputStream.readInt());
            HashMap hashMap = null;
            int readInt4 = dataInputStream.readInt();
            if (readInt4 != 0) {
                hashMap = new HashMap();
                for (int i = 0; i < readInt4; i++) {
                    hashMap.put(dataInputStream.readUTF(), dataInputStream.readUTF());
                }
            }
            long readLong3 = dataInputStream.readLong();
            int readInt5 = dataInputStream.readInt();
            int readInt6 = dataInputStream.readInt();
            String readUTF3 = dataInputStream.readUTF();
            if (readUTF3.equals("")) {
                readUTF3 = null;
            }
            boolean readBoolean = dataInputStream.readBoolean();
            ip ipVar = new ip(readUTF, readLong2, readUTF2, readLong, readInt2, readInt3, a2, hashMap, readInt5, readInt6, readUTF3);
            ipVar.h = readLong3;
            ipVar.m = readBoolean;
            ipVar.p = readInt;
            ipVar.f = (ArrayList) this.f1876a.a(inputStream);
            ipVar.d();
            return ipVar;
        }
    }
}
