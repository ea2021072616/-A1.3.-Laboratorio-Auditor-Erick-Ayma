package b.a.a.a;

import android.util.Log;
/* compiled from: DefaultLogger.java */
/* loaded from: classes.dex */
public class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private int f256a;

    public b(int i) {
        this.f256a = i;
    }

    public b() {
        this.f256a = 4;
    }

    @Override // b.a.a.a.l
    public boolean a(String str, int i) {
        return this.f256a <= i;
    }

    @Override // b.a.a.a.l
    public void a(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    @Override // b.a.a.a.l
    public void d(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // b.a.a.a.l
    public void e(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    @Override // b.a.a.a.l
    public void a(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    @Override // b.a.a.a.l
    public void b(String str, String str2) {
        b(str, str2, null);
    }

    @Override // b.a.a.a.l
    public void c(String str, String str2) {
        c(str, str2, null);
    }

    @Override // b.a.a.a.l
    public void d(String str, String str2) {
        d(str, str2, null);
    }

    @Override // b.a.a.a.l
    public void e(String str, String str2) {
        e(str, str2, null);
    }

    @Override // b.a.a.a.l
    public void a(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    @Override // b.a.a.a.l
    public void a(int i, String str, String str2, boolean z) {
        if (z || a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
