package x0;

import androidx.appcompat.widget.b0;
import androidx.lifecycle.t;
import androidx.lifecycle.v0;
import d.e;
import java.io.PrintWriter;
import l.k;
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public final t f5433a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5434b;

    public c(t tVar, v0 v0Var) {
        this.f5433a = tVar;
        this.f5434b = (b) new e(v0Var, b.f5431e, 0).j(b.class);
    }

    public final void b(String str, PrintWriter printWriter) {
        k kVar = this.f5434b.f5432d;
        if (kVar.f3709d > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (kVar.f3709d <= 0) {
                return;
            }
            b0.n(kVar.f3708c[0]);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(kVar.f3707b[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int lastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        t tVar = this.f5433a;
        if (tVar == null) {
            sb.append("null");
        } else {
            String simpleName = tVar.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = tVar.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(tVar)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
