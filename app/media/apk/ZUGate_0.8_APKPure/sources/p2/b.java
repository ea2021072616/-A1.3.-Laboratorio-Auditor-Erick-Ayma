package p2;

import android.content.Context;
import i2.h;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f4265b = new b();

    /* renamed from: a  reason: collision with root package name */
    public h f4266a = null;

    public static h a(Context context) {
        h hVar;
        b bVar = f4265b;
        synchronized (bVar) {
            if (bVar.f4266a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                bVar.f4266a = new h(context);
            }
            hVar = bVar.f4266a;
        }
        return hVar;
    }
}
