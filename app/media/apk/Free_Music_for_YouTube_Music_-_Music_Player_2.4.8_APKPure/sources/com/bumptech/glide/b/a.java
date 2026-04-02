package com.bumptech.glide.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.flurry.android.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f623a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f624b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private int[] f625c;
    private ByteBuffer d;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private byte[] l;
    private InterfaceC0020a n;
    private Bitmap o;
    private boolean p;
    private int q;
    private final byte[] e = new byte[256];
    private c m = new c();

    /* compiled from: GifDecoder.java */
    /* renamed from: com.bumptech.glide.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0020a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);
    }

    public a(InterfaceC0020a interfaceC0020a) {
        this.n = interfaceC0020a;
    }

    public void a() {
        this.k = (this.k + 1) % this.m.f631c;
    }

    public int a(int i) {
        if (i < 0 || i >= this.m.f631c) {
            return -1;
        }
        return this.m.e.get(i).i;
    }

    public int b() {
        if (this.m.f631c <= 0 || this.k < 0) {
            return -1;
        }
        return a(this.k);
    }

    public int c() {
        return this.m.f631c;
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.m.m;
    }

    public synchronized Bitmap f() {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            if (this.m.f631c <= 0 || this.k < 0) {
                if (Log.isLoggable(f623a, 3)) {
                    Log.d(f623a, "unable to decode frame, frameCount=" + this.m.f631c + " framePointer=" + this.k);
                }
                this.q = 1;
            }
            if (this.q == 1 || this.q == 2) {
                if (Log.isLoggable(f623a, 3)) {
                    Log.d(f623a, "Unable to decode frame, status=" + this.q);
                }
                bitmap = null;
            } else {
                this.q = 0;
                b bVar = this.m.e.get(this.k);
                int i2 = this.k - 1;
                b bVar2 = i2 >= 0 ? this.m.e.get(i2) : null;
                if (bVar.k == null) {
                    this.f625c = this.m.f629a;
                } else {
                    this.f625c = bVar.k;
                    if (this.m.j == bVar.h) {
                        this.m.l = 0;
                    }
                }
                if (bVar.f) {
                    int i3 = this.f625c[bVar.h];
                    this.f625c[bVar.h] = 0;
                    i = i3;
                }
                if (this.f625c == null) {
                    if (Log.isLoggable(f623a, 3)) {
                        Log.d(f623a, "No Valid Color Table");
                    }
                    this.q = 1;
                    bitmap = null;
                } else {
                    Bitmap a2 = a(bVar, bVar2);
                    if (bVar.f) {
                        this.f625c[bVar.h] = i;
                    }
                    bitmap = a2;
                }
            }
        }
        return bitmap;
    }

    public void g() {
        this.m = null;
        this.l = null;
        this.i = null;
        this.j = null;
        if (this.o != null) {
            this.n.a(this.o);
        }
        this.o = null;
        this.d = null;
    }

    public void a(c cVar, byte[] bArr) {
        this.m = cVar;
        this.l = bArr;
        this.q = 0;
        this.k = -1;
        this.d = ByteBuffer.wrap(bArr);
        this.d.rewind();
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.p = false;
        Iterator<b> it = cVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.p = true;
                break;
            }
        }
        this.i = new byte[cVar.f * cVar.g];
        this.j = new int[cVar.f * cVar.g];
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2 = this.m.f;
        int i3 = this.m.g;
        int[] iArr = this.j;
        if (bVar2 != null && bVar2.g > 0) {
            if (bVar2.g == 2) {
                int i4 = 0;
                if (!bVar.f) {
                    i4 = this.m.l;
                }
                Arrays.fill(iArr, i4);
            } else if (bVar2.g == 3 && this.o != null) {
                this.o.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        a(bVar);
        int i5 = 1;
        int i6 = 8;
        int i7 = 0;
        for (int i8 = 0; i8 < bVar.d; i8++) {
            if (bVar.e) {
                if (i7 >= bVar.d) {
                    i5++;
                    switch (i5) {
                        case 2:
                            i7 = 4;
                            break;
                        case 3:
                            i7 = 2;
                            i6 = 4;
                            break;
                        case 4:
                            i7 = 1;
                            i6 = 2;
                            break;
                    }
                }
                int i9 = i7;
                i7 += i6;
                i = i9;
            } else {
                i = i8;
            }
            int i10 = i + bVar.f627b;
            if (i10 < this.m.g) {
                int i11 = this.m.f * i10;
                int i12 = i11 + bVar.f626a;
                int i13 = bVar.f628c + i12;
                if (this.m.f + i11 < i13) {
                    i13 = this.m.f + i11;
                }
                int i14 = bVar.f628c * i8;
                int i15 = i12;
                while (i15 < i13) {
                    int i16 = i14 + 1;
                    int i17 = this.f625c[this.i[i14] & Constants.UNKNOWN];
                    if (i17 != 0) {
                        iArr[i15] = i17;
                    }
                    i15++;
                    i14 = i16;
                }
            }
        }
        if (this.p && (bVar.g == 0 || bVar.g == 1)) {
            if (this.o == null) {
                this.o = j();
            }
            this.o.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap j = j();
        j.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return j;
    }

    private void a(b bVar) {
        short s;
        if (bVar != null) {
            this.d.position(bVar.j);
        }
        int i = bVar == null ? this.m.f * this.m.g : bVar.f628c * bVar.d;
        if (this.i == null || this.i.length < i) {
            this.i = new byte[i];
        }
        if (this.f == null) {
            this.f = new short[4096];
        }
        if (this.g == null) {
            this.g = new byte[4096];
        }
        if (this.h == null) {
            this.h = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int h = h();
        int i2 = 1 << h;
        int i3 = i2 + 1;
        int i4 = i2 + 2;
        int i5 = -1;
        int i6 = h + 1;
        int i7 = (1 << i6) - 1;
        for (int i8 = 0; i8 < i2; i8++) {
            this.f[i8] = 0;
            this.g[i8] = (byte) i8;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = i6;
        int i15 = i7;
        int i16 = i4;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i10 >= i) {
                break;
            }
            if (i18 == 0) {
                i18 = i();
                if (i18 <= 0) {
                    this.q = 3;
                    break;
                }
                i17 = 0;
            }
            int i20 = i9 + ((this.e[i17] & Constants.UNKNOWN) << i13);
            int i21 = i13 + 8;
            int i22 = i17 + 1;
            int i23 = i18 - 1;
            int i24 = i14;
            int i25 = i15;
            int i26 = i12;
            int i27 = i20;
            int i28 = i19;
            int i29 = i16;
            int i30 = i21;
            while (true) {
                if (i30 < i24) {
                    i12 = i26;
                    i15 = i25;
                    i18 = i23;
                    i14 = i24;
                    i17 = i22;
                    int i31 = i30;
                    i16 = i29;
                    i19 = i28;
                    i9 = i27;
                    i13 = i31;
                    break;
                }
                int i32 = i27 & i25;
                int i33 = i27 >> i24;
                i30 -= i24;
                if (i32 == i2) {
                    i24 = h + 1;
                    i25 = (1 << i24) - 1;
                    i29 = i2 + 2;
                    i27 = i33;
                    i5 = -1;
                } else if (i32 > i29) {
                    this.q = 3;
                    i12 = i26;
                    i13 = i30;
                    i14 = i24;
                    i16 = i29;
                    i17 = i22;
                    i19 = i28;
                    i9 = i33;
                    i15 = i25;
                    i18 = i23;
                    break;
                } else if (i32 == i3) {
                    i12 = i26;
                    i13 = i30;
                    i14 = i24;
                    i16 = i29;
                    i17 = i22;
                    i19 = i28;
                    i9 = i33;
                    i15 = i25;
                    i18 = i23;
                    break;
                } else if (i5 == -1) {
                    this.h[i11] = this.g[i32];
                    i11++;
                    i26 = i32;
                    i5 = i32;
                    i27 = i33;
                } else {
                    if (i32 >= i29) {
                        this.h[i11] = (byte) i26;
                        i11++;
                        s = i5;
                    } else {
                        s = i32;
                    }
                    while (s >= i2) {
                        this.h[i11] = this.g[s];
                        s = this.f[s];
                        i11++;
                    }
                    i26 = this.g[s] & Constants.UNKNOWN;
                    int i34 = i11 + 1;
                    this.h[i11] = (byte) i26;
                    if (i29 < 4096) {
                        this.f[i29] = (short) i5;
                        this.g[i29] = (byte) i26;
                        i29++;
                        if ((i29 & i25) == 0 && i29 < 4096) {
                            i24++;
                            i25 += i29;
                        }
                    }
                    int i35 = i10;
                    while (i34 > 0) {
                        int i36 = i34 - 1;
                        this.i[i28] = this.h[i36];
                        i35++;
                        i28++;
                        i34 = i36;
                    }
                    i10 = i35;
                    i5 = i32;
                    i11 = i34;
                    i27 = i33;
                }
            }
        }
        for (int i37 = i19; i37 < i; i37++) {
            this.i[i37] = 0;
        }
    }

    private int h() {
        try {
            return this.d.get() & Constants.UNKNOWN;
        } catch (Exception e) {
            this.q = 1;
            return 0;
        }
    }

    private int i() {
        int h = h();
        int i = 0;
        if (h > 0) {
            while (i < h) {
                int i2 = h - i;
                try {
                    this.d.get(this.e, i, i2);
                    i += i2;
                } catch (Exception e) {
                    Log.w(f623a, "Error Reading Block", e);
                    this.q = 1;
                }
            }
        }
        return i;
    }

    private Bitmap j() {
        Bitmap a2 = this.n.a(this.m.f, this.m.g, f624b);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(this.m.f, this.m.g, f624b);
        }
        a(a2);
        return a2;
    }

    @TargetApi(12)
    private static void a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
