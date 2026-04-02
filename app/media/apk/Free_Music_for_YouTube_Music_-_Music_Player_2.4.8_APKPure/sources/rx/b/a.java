package rx.b;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
/* compiled from: CompositeException.java */
/* loaded from: classes.dex */
public final class a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: a  reason: collision with root package name */
    private final List<Throwable> f5241a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5242b;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f5243c;

    @Deprecated
    public a(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.f5241a = Collections.unmodifiableList(arrayList);
        this.f5242b = this.f5241a.size() + " exceptions occurred. ";
    }

    public a(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public a(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th : thArr) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.f5241a = Collections.unmodifiableList(arrayList);
        this.f5242b = this.f5241a.size() + " exceptions occurred. ";
    }

    public List<Throwable> a() {
        return this.f5241a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f5242b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.f5243c == null) {
            C0106a c0106a = new C0106a();
            HashSet hashSet = new HashSet();
            C0106a c0106a2 = c0106a;
            for (Throwable th : this.f5241a) {
                if (!hashSet.contains(th)) {
                    hashSet.add(th);
                    RuntimeException runtimeException = th;
                    for (Throwable th2 : a(th)) {
                        if (hashSet.contains(th2)) {
                            runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th2);
                        }
                    }
                    try {
                        c0106a2.initCause(runtimeException);
                    } catch (Throwable th3) {
                    }
                    c0106a2 = b(c0106a2);
                }
            }
            this.f5243c = c0106a;
        }
        return this.f5243c;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        ThrowableExtension.printStackTrace(this, System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(new d(printWriter));
    }

    private void a(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this).append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ").append(stackTraceElement).append('\n');
        }
        int i = 1;
        Iterator<Throwable> it = this.f5241a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                sb.append("  ComposedException ").append(i2).append(" :\n");
                a(sb, it.next(), "\t");
                i = i2 + 1;
            } else {
                synchronized (bVar.a()) {
                    bVar.a(sb.toString());
                }
                return;
            }
        }
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str).append(th).append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ").append(stackTraceElement).append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* loaded from: classes2.dex */
    public static abstract class b {
        abstract Object a();

        abstract void a(Object obj);

        b() {
        }
    }

    /* compiled from: CompositeException.java */
    /* loaded from: classes2.dex */
    static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f5244a;

        c(PrintStream printStream) {
            this.f5244a = printStream;
        }

        @Override // rx.b.a.b
        Object a() {
            return this.f5244a;
        }

        @Override // rx.b.a.b
        void a(Object obj) {
            this.f5244a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* loaded from: classes2.dex */
    static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f5245a;

        d(PrintWriter printWriter) {
            this.f5245a = printWriter;
        }

        @Override // rx.b.a.b
        Object a() {
            return this.f5245a;
        }

        @Override // rx.b.a.b
        void a(Object obj) {
            this.f5245a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: rx.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0106a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        C0106a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    private List<Throwable> a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause.getCause();
        }
        return arrayList;
    }

    private Throwable b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                return cause;
            }
            cause = cause.getCause();
        }
    }
}
