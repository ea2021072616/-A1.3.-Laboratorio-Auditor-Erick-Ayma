package z;

import android.content.res.Resources;
import android.os.Build;
import d.u0;
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final u0 f5756a;

    /* renamed from: b  reason: collision with root package name */
    public static final l.e f5757b;

    static {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            f5756a = new k();
        } else if (i5 >= 28) {
            f5756a = new j();
        } else {
            f5756a = new i();
        }
        f5757b = new l.e(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r3.equals(r5) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r16, y.e r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, y.n r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z.g.a(android.content.Context, y.e, android.content.res.Resources, int, java.lang.String, int, int, y.n, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i5, String str, int i6, int i7) {
        return resources.getResourcePackageName(i5) + '-' + str + '-' + i6 + '-' + i5 + '-' + i7;
    }
}
