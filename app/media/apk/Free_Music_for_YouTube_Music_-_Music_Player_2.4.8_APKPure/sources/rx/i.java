package rx;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class i {
    public abstract a createWorker();

    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static abstract class a implements m {
        public abstract m a(rx.c.a aVar);

        public abstract m a(rx.c.a aVar, long j, TimeUnit timeUnit);

        public m a(rx.c.a aVar, long j, long j2, TimeUnit timeUnit) {
            return rx.internal.c.i.a(this, aVar, j, j2, timeUnit, null);
        }

        public long m_() {
            return System.currentTimeMillis();
        }
    }

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends i & m> S when(rx.c.e<f<f<b>>, b> eVar) {
        return new rx.internal.c.l(eVar, this);
    }
}
