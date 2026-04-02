package u0;

import androidx.fragment.app.Fragment;
/* loaded from: classes.dex */
public final class e extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Fragment fragment, int i5) {
        super(0, fragment, "Attempting to get retain instance for fragment " + fragment);
        if (i5 != 1) {
            e4.e.f(fragment, "fragment");
            return;
        }
        e4.e.f(fragment, "fragment");
        super(0, fragment, "Attempting to set retain instance for fragment " + fragment);
    }
}
