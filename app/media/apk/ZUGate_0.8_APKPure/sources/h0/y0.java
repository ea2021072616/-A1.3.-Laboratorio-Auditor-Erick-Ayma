package h0;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.github.appintro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: d  reason: collision with root package name */
    public static final ArrayList f3229d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f3230a = null;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray f3231b = null;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f3232c = null;

    public static void b(View view) {
        int size;
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null || arrayList.size() - 1 < 0) {
            return;
        }
        androidx.appcompat.widget.b0.n(arrayList.get(size));
        throw null;
    }

    public final View a(View view) {
        View a5;
        WeakHashMap weakHashMap = this.f3230a;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                    a5 = a(viewGroup.getChildAt(childCount));
                }
            } while (a5 == null);
            return a5;
        }
        b(view);
        return null;
    }
}
