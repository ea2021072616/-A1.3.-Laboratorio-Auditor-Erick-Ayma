package com.bumptech.glide.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.flurry.android.Constants;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: AnimatedGifEncoder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f635a;

    /* renamed from: b  reason: collision with root package name */
    private int f636b;
    private int d;
    private OutputStream h;
    private Bitmap i;
    private byte[] j;
    private byte[] k;
    private int l;
    private byte[] m;
    private boolean u;

    /* renamed from: c  reason: collision with root package name */
    private Integer f637c = null;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private boolean[] n = new boolean[256];
    private int o = 7;
    private int p = -1;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private int t = 10;

    public void a(int i) {
        this.f = Math.round(i / 10.0f);
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.g) {
            return false;
        }
        try {
            if (!this.s) {
                a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.i = bitmap;
            c();
            b();
            if (this.r) {
                f();
                h();
                if (this.e >= 0) {
                    g();
                }
            }
            d();
            e();
            if (!this.r) {
                h();
            }
            i();
            this.r = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean a() {
        boolean z;
        if (this.g) {
            this.g = false;
            try {
                this.h.write(59);
                this.h.flush();
                if (this.q) {
                    this.h.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.d = 0;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.m = null;
            this.q = false;
            this.r = true;
            return z;
        }
        return false;
    }

    public void a(int i, int i2) {
        if (!this.g || this.r) {
            this.f635a = i;
            this.f636b = i2;
            if (this.f635a < 1) {
                this.f635a = 320;
            }
            if (this.f636b < 1) {
                this.f636b = PsExtractor.VIDEO_STREAM_MASK;
            }
            this.s = true;
        }
    }

    public boolean a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.q = false;
        this.h = outputStream;
        try {
            a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.g = z;
        return z;
    }

    private void b() {
        int length = this.j.length;
        int i = length / 3;
        this.k = new byte[i];
        c cVar = new c(this.j, length, this.t);
        this.m = cVar.d();
        for (int i2 = 0; i2 < this.m.length; i2 += 3) {
            byte b2 = this.m[i2];
            this.m[i2] = this.m[i2 + 2];
            this.m[i2 + 2] = b2;
            this.n[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int a2 = cVar.a(this.j[i3] & Constants.UNKNOWN, this.j[i5] & Constants.UNKNOWN, this.j[i6] & Constants.UNKNOWN);
            this.n[a2] = true;
            this.k[i4] = (byte) a2;
        }
        this.j = null;
        this.l = 8;
        this.o = 7;
        if (this.f637c != null) {
            this.d = b(this.f637c.intValue());
        } else if (this.u) {
            this.d = b(0);
        }
    }

    private int b(int i) {
        int i2;
        int i3 = 0;
        if (this.m == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int i4 = 16777216;
        int length = this.m.length;
        int i5 = 0;
        while (i3 < length) {
            int i6 = i3 + 1;
            int i7 = red - (this.m[i3] & Constants.UNKNOWN);
            int i8 = i6 + 1;
            int i9 = green - (this.m[i6] & Constants.UNKNOWN);
            int i10 = blue - (this.m[i8] & Constants.UNKNOWN);
            int i11 = (i7 * i7) + (i9 * i9) + (i10 * i10);
            int i12 = i8 / 3;
            if (!this.n[i12] || i11 >= i4) {
                i11 = i4;
                i2 = i5;
            } else {
                i2 = i12;
            }
            i5 = i2;
            i4 = i11;
            i3 = i8 + 1;
        }
        return i5;
    }

    private void c() {
        int width = this.i.getWidth();
        int height = this.i.getHeight();
        if (width != this.f635a || height != this.f636b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f635a, this.f636b, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            this.i = createBitmap;
        }
        int[] iArr = new int[width * height];
        this.i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.j = new byte[iArr.length * 3];
        this.u = false;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                i++;
            }
            int i4 = i2 + 1;
            this.j[i2] = (byte) (i3 & 255);
            int i5 = i4 + 1;
            this.j[i4] = (byte) ((i3 >> 8) & 255);
            i2 = i5 + 1;
            this.j[i5] = (byte) ((i3 >> 16) & 255);
        }
        double length = (i * 100) / iArr.length;
        this.u = length > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length + "% transparent pixels");
        }
    }

    private void d() throws IOException {
        int i;
        int i2;
        this.h.write(33);
        this.h.write(249);
        this.h.write(4);
        if (this.f637c != null || this.u) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.p >= 0) {
            i2 = this.p & 7;
        }
        this.h.write((i2 << 2) | 0 | 0 | i);
        c(this.f);
        this.h.write(this.d);
        this.h.write(0);
    }

    private void e() throws IOException {
        this.h.write(44);
        c(0);
        c(0);
        c(this.f635a);
        c(this.f636b);
        if (this.r) {
            this.h.write(0);
        } else {
            this.h.write(this.o | 128);
        }
    }

    private void f() throws IOException {
        c(this.f635a);
        c(this.f636b);
        this.h.write(this.o | PsExtractor.VIDEO_STREAM_MASK);
        this.h.write(0);
        this.h.write(0);
    }

    private void g() throws IOException {
        this.h.write(33);
        this.h.write(255);
        this.h.write(11);
        a("NETSCAPE2.0");
        this.h.write(3);
        this.h.write(1);
        c(this.e);
        this.h.write(0);
    }

    private void h() throws IOException {
        this.h.write(this.m, 0, this.m.length);
        int length = 768 - this.m.length;
        for (int i = 0; i < length; i++) {
            this.h.write(0);
        }
    }

    private void i() throws IOException {
        new b(this.f635a, this.f636b, this.k, this.l).b(this.h);
    }

    private void c(int i) throws IOException {
        this.h.write(i & 255);
        this.h.write((i >> 8) & 255);
    }

    private void a(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.h.write((byte) str.charAt(i));
        }
    }
}
