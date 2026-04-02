package a;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* compiled from: CancellationTokenSource.java */
/* loaded from: classes.dex */
public class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f18b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f19c;
    private boolean d;
    private boolean e;

    public boolean a() {
        boolean z;
        synchronized (this.f17a) {
            b();
            z = this.d;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f17a) {
            if (!this.e) {
                c();
                for (f fVar : this.f18b) {
                    fVar.close();
                }
                this.f18b.clear();
                this.e = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        synchronized (this.f17a) {
            b();
            this.f18b.remove(fVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a()));
    }

    private void b() {
        if (this.e) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void c() {
        if (this.f19c != null) {
            this.f19c.cancel(true);
            this.f19c = null;
        }
    }
}
