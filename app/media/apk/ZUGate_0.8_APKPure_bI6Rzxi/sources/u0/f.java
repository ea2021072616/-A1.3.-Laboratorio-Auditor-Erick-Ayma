package u0;

import androidx.fragment.app.Fragment;
/* loaded from: classes.dex */
public final class f extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Fragment fragment, int i5) {
        super(1, fragment, "Attempting to get target request code from fragment " + fragment);
        if (i5 != 1) {
            e4.e.f(fragment, "fragment");
            return;
        }
        e4.e.f(fragment, "fragment");
        super(1, fragment, "Attempting to get target fragment from fragment " + fragment);
    }
}
