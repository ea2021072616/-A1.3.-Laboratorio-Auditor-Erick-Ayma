package androidx.fragment.app;
/* loaded from: classes.dex */
public final class t extends z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fragment f1007a;

    public t(Fragment fragment) {
        this.f1007a = fragment;
    }

    @Override // androidx.fragment.app.z
    public final void a() {
        Fragment fragment = this.f1007a;
        fragment.mSavedStateRegistryController.a();
        b4.j.o(fragment);
    }
}
