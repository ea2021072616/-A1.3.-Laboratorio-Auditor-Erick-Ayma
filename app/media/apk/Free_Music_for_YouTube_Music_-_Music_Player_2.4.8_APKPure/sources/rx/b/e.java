package rx.b;
/* compiled from: OnErrorFailedException.java */
/* loaded from: classes2.dex */
public class e extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public e(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public e(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
