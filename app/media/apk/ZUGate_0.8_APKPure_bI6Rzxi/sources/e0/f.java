package e0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.appcompat.widget.s;
import d.m;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l.j;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final l.e f2573a = new l.e(16);

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadPoolExecutor f2574b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f2575c;

    /* renamed from: d  reason: collision with root package name */
    public static final j f2576d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new i());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f2574b = threadPoolExecutor;
        f2575c = new Object();
        f2576d = new j();
    }

    public static e a(String str, Context context, s sVar, int i5) {
        int i6;
        l.e eVar = f2573a;
        Typeface typeface = (Typeface) eVar.a(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            m t5 = b4.j.t(context, sVar);
            int i7 = t5.f2397g;
            int i8 = 1;
            Object obj = t5.f2398h;
            if (i7 != 0) {
                if (i7 == 1) {
                    i6 = -2;
                }
                i6 = -3;
            } else {
                g[] gVarArr = (g[]) obj;
                if (gVarArr != null && gVarArr.length != 0) {
                    for (g gVar : gVarArr) {
                        int i9 = gVar.f2581e;
                        if (i9 != 0) {
                            if (i9 >= 0) {
                                i6 = i9;
                            }
                            i6 = -3;
                        }
                    }
                    i8 = 0;
                }
                i6 = i8;
            }
            if (i6 != 0) {
                return new e(i6);
            }
            Typeface w5 = z.g.f5756a.w(context, (g[]) obj, i5);
            if (w5 != null) {
                eVar.b(str, w5);
                return new e(w5);
            }
            return new e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }
}
