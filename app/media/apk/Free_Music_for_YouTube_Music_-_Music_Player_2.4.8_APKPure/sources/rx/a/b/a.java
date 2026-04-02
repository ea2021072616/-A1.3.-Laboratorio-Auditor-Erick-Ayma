package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.i;
/* compiled from: AndroidSchedulers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<a> f5223a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final i f5224b;

    private static a b() {
        a aVar;
        do {
            aVar = f5223a.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!f5223a.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        i b2 = rx.a.a.a.a().b().b();
        if (b2 != null) {
            this.f5224b = b2;
        } else {
            this.f5224b = new b(Looper.getMainLooper());
        }
    }

    public static i a() {
        return b().f5224b;
    }
}
