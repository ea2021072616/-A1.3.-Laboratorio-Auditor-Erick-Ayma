package a;
/* compiled from: ExecutorException.java */
/* loaded from: classes.dex */
public class i extends RuntimeException {
    public i(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
