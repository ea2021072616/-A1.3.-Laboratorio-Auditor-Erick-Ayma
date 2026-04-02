package rx.b;
/* compiled from: UnsubscribeFailedException.java */
/* loaded from: classes2.dex */
public final class h extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    public h(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }
}
