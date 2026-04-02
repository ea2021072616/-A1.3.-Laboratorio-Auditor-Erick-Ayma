package a;
/* compiled from: TaskCompletionSource.java */
/* loaded from: classes.dex */
public class k<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final j<TResult> f40a = new j<>();

    public j<TResult> a() {
        return this.f40a;
    }

    public boolean b() {
        return this.f40a.i();
    }

    public boolean a(TResult tresult) {
        return this.f40a.b((j<TResult>) tresult);
    }

    public boolean a(Exception exc) {
        return this.f40a.b(exc);
    }

    public void c() {
        if (!b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void b(TResult tresult) {
        if (!a((k<TResult>) tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void b(Exception exc) {
        if (!a(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
