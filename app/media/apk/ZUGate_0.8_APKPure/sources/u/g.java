package u;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.s;
import h0.o0;
import h0.z0;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class g implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5113a;

    public /* synthetic */ g(int i5) {
        this.f5113a = i5;
    }

    public final int a(View view, View view2) {
        switch (this.f5113a) {
            case 0:
                WeakHashMap weakHashMap = z0.f3233a;
                float m5 = o0.m(view);
                float m6 = o0.m(view2);
                if (m5 > m6) {
                    return -1;
                }
                return m5 < m6 ? 1 : 0;
            default:
                return view.getTop() - view2.getTop();
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f5113a) {
            case 0:
                return a((View) obj, (View) obj2);
            case 1:
                ((l) obj).getClass();
                ((l) obj2).getClass();
                return 0 - 0;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                s sVar = (s) obj;
                s sVar2 = (s) obj2;
                RecyclerView recyclerView = sVar.f1518d;
                if ((recyclerView == null) == (sVar2.f1518d == null)) {
                    boolean z4 = sVar.f1515a;
                    if (z4 == sVar2.f1515a) {
                        int i5 = sVar2.f1516b - sVar.f1516b;
                        if (i5 != 0) {
                            return i5;
                        }
                        int i6 = sVar.f1517c - sVar2.f1517c;
                        if (i6 != 0) {
                            return i6;
                        }
                        return 0;
                    } else if (z4) {
                        return -1;
                    }
                } else if (recyclerView != null) {
                    return -1;
                }
                return 1;
            case 3:
                return ((androidx.viewpager.widget.c) obj).f1590b - ((androidx.viewpager.widget.c) obj2).f1590b;
            case 4:
                return a((View) obj, (View) obj2);
            default:
                Integer valueOf = Integer.valueOf(((Constructor) obj2).getParameterTypes().length);
                Integer valueOf2 = Integer.valueOf(((Constructor) obj).getParameterTypes().length);
                if (valueOf == valueOf2) {
                    return 0;
                }
                if (valueOf == null) {
                    return -1;
                }
                if (valueOf2 == null) {
                    return 1;
                }
                return valueOf.compareTo(valueOf2);
        }
    }
}
