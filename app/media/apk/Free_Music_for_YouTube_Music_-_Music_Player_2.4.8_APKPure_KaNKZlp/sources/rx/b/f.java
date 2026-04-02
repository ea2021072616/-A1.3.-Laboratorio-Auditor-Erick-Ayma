package rx.b;
/* compiled from: OnErrorNotImplementedException.java */
/* loaded from: classes2.dex */
public class f extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public f(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public f(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
