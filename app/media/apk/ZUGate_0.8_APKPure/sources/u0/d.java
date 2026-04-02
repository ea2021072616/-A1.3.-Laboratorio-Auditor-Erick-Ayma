package u0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
/* loaded from: classes.dex */
public final class d extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Fragment fragment, String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        e4.e.f(fragment, "fragment");
        e4.e.f(str, "previousFragmentId");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Fragment fragment, ViewGroup viewGroup, int i5) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        if (i5 != 1) {
            return;
        }
        e4.e.f(viewGroup, "container");
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
    }
}
