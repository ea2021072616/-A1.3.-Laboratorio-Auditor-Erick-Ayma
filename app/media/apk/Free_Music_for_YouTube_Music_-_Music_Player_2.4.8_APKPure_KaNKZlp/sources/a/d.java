package a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: BoltsExecutors.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final d f9a = new d();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f10b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f11c;
    private final Executor d;

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private d() {
        this.f10b = !c() ? Executors.newCachedThreadPool() : a.a.a();
        this.f11c = Executors.newSingleThreadScheduledExecutor();
        this.d = new a();
    }

    public static ExecutorService a() {
        return f9a.f10b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b() {
        return f9a.d;
    }

    /* compiled from: BoltsExecutors.java */
    /* loaded from: classes.dex */
    private static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private ThreadLocal<Integer> f12a;

        private a() {
            this.f12a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f12a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f12a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int b() {
            Integer num = this.f12a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f12a.remove();
            } else {
                this.f12a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (a() <= 15) {
                    runnable.run();
                } else {
                    d.a().execute(runnable);
                }
            } finally {
                b();
            }
        }
    }
}
