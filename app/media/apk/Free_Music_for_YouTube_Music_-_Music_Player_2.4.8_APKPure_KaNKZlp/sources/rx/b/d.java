package rx.b;
/* compiled from: OnCompletedFailedException.java */
/* loaded from: classes2.dex */
public final class d extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public d(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }
}
