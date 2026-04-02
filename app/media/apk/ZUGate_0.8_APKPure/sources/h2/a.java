package h2;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.play_billing.i0;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f3345c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static a f3346d;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f3347a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f3348b;

    public a(Context context) {
        this.f3348b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        i0.j(context);
        ReentrantLock reentrantLock = f3345c;
        reentrantLock.lock();
        try {
            if (f3346d == null) {
                f3346d = new a(context.getApplicationContext());
            }
            return f3346d;
        } finally {
            reentrantLock.unlock();
        }
    }
}
