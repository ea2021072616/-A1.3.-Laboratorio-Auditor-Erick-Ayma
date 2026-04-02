package u0;

import androidx.fragment.app.Fragment;
/* loaded from: classes.dex */
public final class h extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Fragment fragment, Fragment fragment2, int i5) {
        super(1, fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i5 + " for fragment " + fragment);
        e4.e.f(fragment, "fragment");
        e4.e.f(fragment2, "targetFragment");
    }
}
