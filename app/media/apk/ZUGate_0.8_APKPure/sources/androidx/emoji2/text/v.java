package androidx.emoji2.text;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public int f789a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f790b;

    /* renamed from: c  reason: collision with root package name */
    public a0 f791c;

    /* renamed from: d  reason: collision with root package name */
    public a0 f792d;

    /* renamed from: e  reason: collision with root package name */
    public int f793e;

    /* renamed from: f  reason: collision with root package name */
    public int f794f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f795g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f796h;

    public v(a0 a0Var, boolean z4, int[] iArr) {
        this.f790b = a0Var;
        this.f791c = a0Var;
        this.f795g = z4;
        this.f796h = iArr;
    }

    public final void a() {
        this.f789a = 1;
        this.f791c = this.f790b;
        this.f794f = 0;
    }

    public final boolean b() {
        int[] iArr;
        r0.a c5 = this.f791c.f744b.c();
        int a5 = c5.a(6);
        if ((a5 == 0 || c5.f4467b.get(a5 + c5.f4466a) == 0) ? false : true) {
            return true;
        }
        if (this.f793e == 65039) {
            return true;
        }
        return this.f795g && ((iArr = this.f796h) == null || Arrays.binarySearch(iArr, this.f791c.f744b.a(0)) < 0);
    }
}
