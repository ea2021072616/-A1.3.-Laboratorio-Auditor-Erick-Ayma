package z0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final m.h f5799a = new m.h();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f5800b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static l2.i f5801c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? j.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static l2.i b(int i5, boolean z4, boolean z5) {
        l2.i iVar = new l2.i();
        f5801c = iVar;
        m.h hVar = f5799a;
        hVar.getClass();
        if (m.g.f3920g.e(hVar, null, iVar)) {
            m.g.b(hVar);
        }
        return f5801c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:14|(1:78)(1:18)|19|(1:77)(1:23)|24|25|26|(2:63|64)(1:28)|29|(8:36|(1:40)|(1:47)|48|(2:55|56)|52|53|54)|(1:62)|(1:40)|(3:42|45|47)|48|(1:50)|55|56|52|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00cb, code lost:
        r3 = 196608;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.l.c(android.content.Context, boolean):void");
    }
}
