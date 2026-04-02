package androidx.biometric;

import android.os.Looper;
import androidx.lifecycle.r0;
/* loaded from: classes.dex */
public final class x extends r0 {

    /* renamed from: d  reason: collision with root package name */
    public p2.a f646d;

    /* renamed from: e  reason: collision with root package name */
    public t f647e;

    /* renamed from: f  reason: collision with root package name */
    public g.f f648f;

    /* renamed from: g  reason: collision with root package name */
    public r f649g;

    /* renamed from: h  reason: collision with root package name */
    public r f650h;

    /* renamed from: i  reason: collision with root package name */
    public w f651i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f652j;

    /* renamed from: l  reason: collision with root package name */
    public boolean f654l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f655m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f656n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f657p;

    /* renamed from: q  reason: collision with root package name */
    public androidx.lifecycle.a0 f658q;

    /* renamed from: r  reason: collision with root package name */
    public androidx.lifecycle.a0 f659r;

    /* renamed from: s  reason: collision with root package name */
    public androidx.lifecycle.a0 f660s;

    /* renamed from: t  reason: collision with root package name */
    public androidx.lifecycle.a0 f661t;

    /* renamed from: u  reason: collision with root package name */
    public androidx.lifecycle.a0 f662u;

    /* renamed from: w  reason: collision with root package name */
    public androidx.lifecycle.a0 f664w;

    /* renamed from: y  reason: collision with root package name */
    public androidx.lifecycle.a0 f666y;

    /* renamed from: z  reason: collision with root package name */
    public androidx.lifecycle.a0 f667z;

    /* renamed from: k  reason: collision with root package name */
    public int f653k = 0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f663v = true;

    /* renamed from: x  reason: collision with root package name */
    public int f665x = 0;

    public static void i(androidx.lifecycle.a0 a0Var, Object obj) {
        boolean z4;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a0Var.f(obj);
            return;
        }
        synchronized (a0Var.f1165a) {
            z4 = a0Var.f1170f == androidx.lifecycle.z.f1164k;
            a0Var.f1170f = obj;
        }
        if (z4) {
            i.b.c0().e0(a0Var.f1174j);
        }
    }

    public final int c() {
        t tVar = this.f647e;
        if (tVar != null) {
            g.f fVar = this.f648f;
            int i5 = tVar.f642g;
            if (i5 != 0) {
                return i5;
            }
            int i6 = fVar != null ? 15 : 255;
            return tVar.f641f ? i6 | 32768 : i6;
        }
        return 0;
    }

    public final CharSequence d() {
        CharSequence charSequence = this.f652j;
        if (charSequence != null) {
            return charSequence;
        }
        t tVar = this.f647e;
        if (tVar != null) {
            CharSequence charSequence2 = tVar.f639d;
            return charSequence2 != null ? charSequence2 : "";
        }
        return null;
    }

    public final void e(e eVar) {
        if (this.f659r == null) {
            this.f659r = new androidx.lifecycle.a0();
        }
        i(this.f659r, eVar);
    }

    public final void f(CharSequence charSequence) {
        if (this.f667z == null) {
            this.f667z = new androidx.lifecycle.a0();
        }
        i(this.f667z, charSequence);
    }

    public final void g(int i5) {
        if (this.f666y == null) {
            this.f666y = new androidx.lifecycle.a0();
        }
        i(this.f666y, Integer.valueOf(i5));
    }

    public final void h(boolean z4) {
        if (this.f662u == null) {
            this.f662u = new androidx.lifecycle.a0();
        }
        i(this.f662u, Boolean.valueOf(z4));
    }
}
