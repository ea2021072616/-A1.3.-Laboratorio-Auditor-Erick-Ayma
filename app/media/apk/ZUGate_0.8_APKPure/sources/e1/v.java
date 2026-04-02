package e1;

import android.view.ViewGroup;
import com.github.appintro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2678a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f2679b = new ThreadLocal();

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayList f2680c = new ArrayList();

    public static void a(ViewGroup viewGroup, r rVar) {
        ArrayList arrayList = f2680c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (rVar == null) {
            rVar = f2678a;
        }
        r clone = rVar.clone();
        ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((r) it.next()).y(viewGroup);
            }
        }
        if (clone != null) {
            clone.i(viewGroup, true);
        }
        androidx.appcompat.widget.b0.n(viewGroup.getTag(R.id.transition_current_scene));
        viewGroup.setTag(R.id.transition_current_scene, null);
        if (clone != null) {
            u uVar = new u(viewGroup, clone);
            viewGroup.addOnAttachStateChangeListener(uVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(uVar);
        }
    }

    public static l.b b() {
        l.b bVar;
        ThreadLocal threadLocal = f2679b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference == null || (bVar = (l.b) weakReference.get()) == null) {
            l.b bVar2 = new l.b();
            threadLocal.set(new WeakReference(bVar2));
            return bVar2;
        }
        return bVar;
    }
}
