package com.bumptech.glide.i;

import android.util.Log;
import java.util.Queue;
/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f719b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Queue<byte[]> f720a = h.a(0);

    public static a a() {
        return f719b;
    }

    private a() {
    }

    public byte[] b() {
        byte[] poll;
        synchronized (this.f720a) {
            poll = this.f720a.poll();
        }
        if (poll == null) {
            poll = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return poll;
    }

    public boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr.length == 65536) {
            synchronized (this.f720a) {
                if (this.f720a.size() < 32) {
                    z = true;
                    this.f720a.offer(bArr);
                }
            }
        }
        return z;
    }
}
