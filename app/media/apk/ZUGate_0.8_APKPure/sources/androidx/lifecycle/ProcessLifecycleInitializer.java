package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements c1.b {
    @Override // c1.b
    public final List a() {
        return b4.f.f1659b;
    }

    @Override // c1.b
    public final Object b(Context context) {
        e4.e.f(context, "context");
        c1.a c5 = c1.a.c(context);
        e4.e.e(c5, "getInstance(context)");
        if (c5.f1712b.contains(ProcessLifecycleInitializer.class)) {
            if (!q.f1140a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                e4.e.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new p());
            }
            h0 h0Var = h0.o;
            h0Var.getClass();
            h0Var.f1109k = new Handler();
            h0Var.f1110l.e(m.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            e4.e.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new f0(h0Var));
            return h0Var;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
