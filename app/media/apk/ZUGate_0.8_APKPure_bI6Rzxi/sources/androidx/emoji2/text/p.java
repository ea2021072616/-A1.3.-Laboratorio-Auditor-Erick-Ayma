package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public final class p extends b4.j {

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ b4.j f783x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f784y;

    public p(b4.j jVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f783x = jVar;
        this.f784y = threadPoolExecutor;
    }

    @Override // b4.j
    public final void E(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f784y;
        try {
            this.f783x.E(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // b4.j
    public final void F(g.f fVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f784y;
        try {
            this.f783x.F(fVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
