package com.facebook.ads.internal.i.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final h f1412a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.i.b.a.b f1413b;

    /* renamed from: c  reason: collision with root package name */
    private b f1414c;

    public e(h hVar, com.facebook.ads.internal.i.b.a.b bVar) {
        super(hVar, bVar);
        this.f1413b = bVar;
        this.f1412a = hVar;
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j, bArr.length);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j += a2;
            }
        }
    }

    private boolean a(d dVar) {
        int a2 = this.f1412a.a();
        boolean z = a2 > 0;
        int a3 = this.f1413b.a();
        if (z && dVar.f1411c) {
            if (((float) dVar.f1410b) > (a2 * 0.2f) + a3) {
                return false;
            }
        }
        return true;
    }

    private String b(d dVar) {
        String c2 = this.f1412a.c();
        boolean z = !TextUtils.isEmpty(c2);
        int a2 = this.f1413b.d() ? this.f1413b.a() : this.f1412a.a();
        boolean z2 = a2 >= 0;
        return (dVar.f1411c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z2 ? String.format("Content-Length: %d\n", Long.valueOf(dVar.f1411c ? a2 - dVar.f1410b : a2)) : "") + (z2 && dVar.f1411c ? String.format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f1410b), Integer.valueOf(a2 - 1), Integer.valueOf(a2)) : "") + (z ? String.format("Content-Type: %s\n", c2) : "") + "\n";
    }

    private void b(OutputStream outputStream, long j) {
        try {
            h hVar = new h(this.f1412a);
            hVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = hVar.a(bArr);
                if (a2 == -1) {
                    outputStream.flush();
                    return;
                } else {
                    outputStream.write(bArr, 0, a2);
                    j += a2;
                }
            }
        } finally {
            this.f1412a.b();
        }
    }

    @Override // com.facebook.ads.internal.i.b.k
    protected void a(int i) {
        if (this.f1414c != null) {
            this.f1414c.a(this.f1413b.f1399a, this.f1412a.f1433a, i);
        }
    }

    public void a(b bVar) {
        this.f1414c = bVar;
    }

    public void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes(C.UTF8_NAME));
        long j = dVar.f1410b;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
