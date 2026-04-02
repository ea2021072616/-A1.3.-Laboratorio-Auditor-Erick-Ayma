package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements c1.b {
    @Override // c1.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // c1.b
    /* renamed from: c */
    public final Boolean b(Context context) {
        Object obj;
        n nVar = new n(context);
        if (m.f769k == null) {
            synchronized (m.f768j) {
                if (m.f769k == null) {
                    m.f769k = new m(nVar);
                }
            }
        }
        c1.a c5 = c1.a.c(context);
        c5.getClass();
        synchronized (c1.a.f1710e) {
            try {
                obj = c5.f1711a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c5.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.o lifecycle = ((androidx.lifecycle.t) obj).getLifecycle();
        lifecycle.a(new androidx.lifecycle.e() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.e
            public final void a() {
                EmojiCompatInitializer.this.getClass();
                (Build.VERSION.SDK_INT >= 28 ? c.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new q(), 500L);
                lifecycle.b(this);
            }
        });
        return Boolean.TRUE;
    }
}
