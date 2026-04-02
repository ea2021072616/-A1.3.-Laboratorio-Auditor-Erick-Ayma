package androidx.fragment.app;
/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f997b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f998c;

    public /* synthetic */ s(Fragment fragment, int i5) {
        this.f997b = i5;
        this.f998c = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f997b;
        Fragment fragment = this.f998c;
        switch (i5) {
            case 0:
                fragment.startPostponedEnterTransition();
                return;
            default:
                fragment.callStartTransitionListener(false);
                return;
        }
    }
}
