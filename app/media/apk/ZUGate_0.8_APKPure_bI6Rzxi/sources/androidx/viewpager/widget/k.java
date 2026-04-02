package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;
/* loaded from: classes.dex */
public final class k implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        d dVar = (d) ((View) obj).getLayoutParams();
        d dVar2 = (d) ((View) obj2).getLayoutParams();
        boolean z4 = dVar.f1594a;
        return z4 != dVar2.f1594a ? z4 ? 1 : -1 : dVar.f1598e - dVar2.f1598e;
    }
}
