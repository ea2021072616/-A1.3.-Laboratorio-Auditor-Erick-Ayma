package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
/* loaded from: classes.dex */
public abstract class e3 extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f342a = new Object();

    public static void a(Context context) {
        if (context.getResources() instanceof g3) {
            return;
        }
        context.getResources();
        int i5 = s3.f528a;
    }
}
