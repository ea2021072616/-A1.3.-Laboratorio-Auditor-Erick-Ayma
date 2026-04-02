package y;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f5568a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap f5569b = new WeakHashMap(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f5570c = new Object();

    public static Typeface a(Context context, int i5) {
        if (context.isRestricted()) {
            return null;
        }
        return c(context, i5, new TypedValue(), 0, null, false, false);
    }

    public static void b(Context context, int i5, n nVar) {
        if (context.isRestricted()) {
            nVar.callbackFailAsync(-4, null);
        } else {
            c(context, i5, new TypedValue(), 0, nVar, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface c(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, y.n r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.q.c(android.content.Context, int, android.util.TypedValue, int, y.n, boolean, boolean):android.graphics.Typeface");
    }
}
