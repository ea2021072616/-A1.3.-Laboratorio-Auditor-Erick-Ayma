package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes.dex */
public abstract class z implements Iterable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final a0 f1994c = new a0(s0.f1954b);

    /* renamed from: b  reason: collision with root package name */
    public int f1995b = 0;

    static {
        int i5 = u.f1960a;
    }

    public static int j(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) < 0) {
            if (i5 < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
            } else if (i6 < i5) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
            } else {
                throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
            }
        }
        return i8;
    }

    public static a0 k(byte[] bArr, int i5, int i6) {
        j(i5, i5 + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return new a0(bArr2);
    }

    /* renamed from: e */
    public final int hashCode() {
        int i5 = this.f1995b;
        if (i5 == 0) {
            int i6 = i();
            a0 a0Var = (a0) this;
            int i7 = i6;
            for (int i8 = 0; i8 < i6; i8++) {
                i7 = (i7 * 31) + a0Var.f1833d[i8];
            }
            i5 = i7 == 0 ? 1 : i7;
            this.f1995b = i5;
        }
        return i5;
    }

    /* renamed from: f */
    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(i());
        if (i() <= 50) {
            concat = e4.e.j0(this);
        } else {
            a0 a0Var = (a0) this;
            int j5 = j(0, 47, a0Var.i());
            concat = e4.e.j0(j5 == 0 ? f1994c : new y(a0Var.f1833d, j5)).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte g(int i5);

    public abstract byte h(int i5);

    public abstract int i();

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new w(this);
    }
}
