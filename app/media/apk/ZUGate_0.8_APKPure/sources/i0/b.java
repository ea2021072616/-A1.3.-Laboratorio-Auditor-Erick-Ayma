package i0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final w.g f3361a;

    public b(w.g gVar) {
        this.f3361a = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f3361a.equals(((b) obj).f3361a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3361a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z4) {
        s3.k kVar = (s3.k) this.f3361a.f5249h;
        AutoCompleteTextView autoCompleteTextView = kVar.f4884h;
        if (autoCompleteTextView != null) {
            if (autoCompleteTextView.getInputType() != 0) {
                return;
            }
            int i5 = z4 ? 2 : 1;
            WeakHashMap weakHashMap = z0.f3233a;
            kVar.f4918d.setImportantForAccessibility(i5);
        }
    }
}
