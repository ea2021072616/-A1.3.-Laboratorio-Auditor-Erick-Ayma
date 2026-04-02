package com.bumptech.glide.b;

import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.flurry.android.Constants;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f633b;

    /* renamed from: c  reason: collision with root package name */
    private c f634c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f632a = new byte[256];
    private int d = 0;

    public d a(byte[] bArr) {
        c();
        if (bArr != null) {
            this.f633b = ByteBuffer.wrap(bArr);
            this.f633b.rewind();
            this.f633b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f633b = null;
            this.f634c.f630b = 2;
        }
        return this;
    }

    public void a() {
        this.f633b = null;
        this.f634c = null;
    }

    private void c() {
        this.f633b = null;
        Arrays.fill(this.f632a, (byte) 0);
        this.f634c = new c();
        this.d = 0;
    }

    public c b() {
        if (this.f633b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (o()) {
            return this.f634c;
        }
        h();
        if (!o()) {
            d();
            if (this.f634c.f631c < 0) {
                this.f634c.f630b = 1;
            }
        }
        return this.f634c;
    }

    private void d() {
        boolean z = false;
        while (!z && !o()) {
            switch (m()) {
                case 33:
                    switch (m()) {
                        case 1:
                            k();
                            continue;
                        case 249:
                            this.f634c.d = new b();
                            e();
                            continue;
                        case 254:
                            k();
                            continue;
                        case 255:
                            l();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.f632a[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                g();
                                break;
                            } else {
                                k();
                                continue;
                            }
                        default:
                            k();
                            continue;
                    }
                case 44:
                    if (this.f634c.d == null) {
                        this.f634c.d = new b();
                    }
                    f();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.f634c.f630b = 1;
                    break;
            }
        }
    }

    private void e() {
        m();
        int m = m();
        this.f634c.d.g = (m & 28) >> 2;
        if (this.f634c.d.g == 0) {
            this.f634c.d.g = 1;
        }
        this.f634c.d.f = (m & 1) != 0;
        int n = n();
        if (n < 3) {
            n = 10;
        }
        this.f634c.d.i = n * 10;
        this.f634c.d.h = m();
        m();
    }

    private void f() {
        this.f634c.d.f626a = n();
        this.f634c.d.f627b = n();
        this.f634c.d.f628c = n();
        this.f634c.d.d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f634c.d.e = (m & 64) != 0;
        if (z) {
            this.f634c.d.k = a(pow);
        } else {
            this.f634c.d.k = null;
        }
        this.f634c.d.j = this.f633b.position();
        j();
        if (!o()) {
            this.f634c.f631c++;
            this.f634c.e.add(this.f634c.d);
        }
    }

    private void g() {
        do {
            l();
            if (this.f632a[0] == 1) {
                this.f634c.m = (this.f632a[1] & Constants.UNKNOWN) | ((this.f632a[2] & Constants.UNKNOWN) << 8);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m());
        }
        if (!str.startsWith("GIF")) {
            this.f634c.f630b = 1;
            return;
        }
        i();
        if (this.f634c.h && !o()) {
            this.f634c.f629a = a(this.f634c.i);
            this.f634c.l = this.f634c.f629a[this.f634c.j];
        }
    }

    private void i() {
        this.f634c.f = n();
        this.f634c.g = n();
        int m = m();
        this.f634c.h = (m & 128) != 0;
        this.f634c.i = 2 << (m & 7);
        this.f634c.j = m();
        this.f634c.k = m();
    }

    private int[] a(int i) {
        int[] iArr;
        BufferUnderflowException e;
        int i2 = 0;
        byte[] bArr = new byte[i * 3];
        try {
            this.f633b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & Constants.UNKNOWN;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & Constants.UNKNOWN;
                    i3 = i6 + 1;
                    int i8 = i2 + 1;
                    iArr[i2] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & Constants.UNKNOWN);
                    i2 = i8;
                } catch (BufferUnderflowException e2) {
                    e = e2;
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
                    }
                    this.f634c.f630b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException e3) {
            iArr = null;
            e = e3;
        }
        return iArr;
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f633b.position(this.f633b.position() + m);
        } while (m > 0);
    }

    private int l() {
        int i = 0;
        this.d = m();
        if (this.d > 0) {
            int i2 = 0;
            while (i < this.d) {
                try {
                    i2 = this.d - i;
                    this.f633b.get(this.f632a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d, e);
                    }
                    this.f634c.f630b = 1;
                }
            }
        }
        return i;
    }

    private int m() {
        try {
            return this.f633b.get() & Constants.UNKNOWN;
        } catch (Exception e) {
            this.f634c.f630b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f633b.getShort();
    }

    private boolean o() {
        return this.f634c.f630b != 0;
    }
}
