package u0;

import androidx.fragment.app.Fragment;
/* loaded from: classes.dex */
public abstract class j extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    public final Fragment f5129b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Fragment fragment, String str) {
        super(str);
        e4.e.f(fragment, "fragment");
        this.f5129b = fragment;
    }
}
