package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class s1 implements h1 {

    /* renamed from: a  reason: collision with root package name */
    public final j1 f1955a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1956b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f1957c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1958d;

    public s1(l0 l0Var, String str, Object[] objArr) {
        this.f1955a = l0Var;
        this.f1956b = str;
        this.f1957c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f1958d = charAt;
            return;
        }
        int i5 = charAt & 8191;
        int i6 = 13;
        int i7 = 1;
        while (true) {
            int i8 = i7 + 1;
            char charAt2 = str.charAt(i7);
            if (charAt2 < 55296) {
                this.f1958d = i5 | (charAt2 << i6);
                return;
            }
            i5 |= (charAt2 & 8191) << i6;
            i6 += 13;
            i7 = i8;
        }
    }

    public final j1 a() {
        return this.f1955a;
    }

    public final int b() {
        int i5 = this.f1958d;
        if ((i5 & 1) != 0) {
            return 1;
        }
        return (i5 & 4) == 4 ? 3 : 2;
    }

    public final String c() {
        return this.f1956b;
    }

    public final Object[] d() {
        return this.f1957c;
    }
}
