package androidx.fragment.app;
/* loaded from: classes.dex */
public final class r0 implements a1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f993g;

    public r0(Fragment fragment) {
        this.f993g = fragment;
    }

    @Override // androidx.fragment.app.a1
    public final void a(Fragment fragment) {
        this.f993g.onAttachFragment(fragment);
    }
}
