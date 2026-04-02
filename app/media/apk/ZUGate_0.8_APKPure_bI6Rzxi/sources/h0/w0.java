package h0;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;
/* loaded from: classes.dex */
public final class w0 implements OnReceiveContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final y f3221a;

    public w0(y yVar) {
        this.f3221a = yVar;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        g gVar = new g(new d.u0(contentInfo));
        g a5 = ((n0.r) this.f3221a).a(view, gVar);
        if (a5 == null) {
            return null;
        }
        if (a5 == gVar) {
            return contentInfo;
        }
        ContentInfo m5 = a5.f3131a.m();
        Objects.requireNonNull(m5);
        return b3.a.h(m5);
    }
}
