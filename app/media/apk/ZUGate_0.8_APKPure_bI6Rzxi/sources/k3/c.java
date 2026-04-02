package k3;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.t;
import java.util.Objects;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public OnBackInvokedCallback f3646a;

    public OnBackInvokedCallback a(b bVar) {
        Objects.requireNonNull(bVar);
        return new t(2, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        r3 = r3.findOnBackInvokedDispatcher();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(k3.b r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            android.window.OnBackInvokedCallback r0 = r1.f3646a
            if (r0 == 0) goto L5
            return
        L5:
            android.window.OnBackInvokedDispatcher r3 = androidx.activity.o.d(r3)
            if (r3 != 0) goto Lc
            return
        Lc:
            android.window.OnBackInvokedCallback r2 = r1.a(r2)
            r1.f3646a = r2
            if (r4 == 0) goto L18
            r4 = 1000000(0xf4240, float:1.401298E-39)
            goto L19
        L18:
            r4 = 0
        L19:
            androidx.activity.o.g(r3, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.c.b(k3.b, android.view.View, boolean):void");
    }

    public void c(View view) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher;
        findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
        if (findOnBackInvokedDispatcher == null) {
            return;
        }
        findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f3646a);
        this.f3646a = null;
    }
}
