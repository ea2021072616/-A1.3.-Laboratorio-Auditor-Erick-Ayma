package e1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class u implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public final r f2676g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f2677h;

    public u(ViewGroup viewGroup, r rVar) {
        this.f2676g = rVar;
        this.f2677h = viewGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ee A[EDGE_INSN: B:144:0x01ee->B:95:0x01ee ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f4  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onPreDraw() {
        /*
            Method dump skipped, instructions count: 701
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.u.onPreDraw():boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f2677h;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        v.f2680c.remove(viewGroup);
        ArrayList arrayList = (ArrayList) v.b().getOrDefault(viewGroup, null);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((r) it.next()).B(viewGroup);
            }
        }
        this.f2676g.j(true);
    }
}
