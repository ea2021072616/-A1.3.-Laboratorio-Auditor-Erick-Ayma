package u0;

import androidx.fragment.app.Fragment;
/* loaded from: classes.dex */
public abstract class g extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i5, Fragment fragment, String str) {
        super(fragment, str);
        if (i5 != 1) {
            e4.e.f(fragment, "fragment");
            return;
        }
        e4.e.f(fragment, "fragment");
        super(fragment, str);
    }
}
