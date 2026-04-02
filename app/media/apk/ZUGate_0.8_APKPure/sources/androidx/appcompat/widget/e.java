package androidx.appcompat.widget;
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f318c;

    public /* synthetic */ e(ActionBarOverlayLayout actionBarOverlayLayout, int i5) {
        this.f317b = i5;
        this.f318c = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f317b;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f318c;
        switch (i5) {
            case 0:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.C = actionBarOverlayLayout.f187j.animate().translationY(0.0f).setListener(actionBarOverlayLayout.D);
                return;
            default:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.C = actionBarOverlayLayout.f187j.animate().translationY(-actionBarOverlayLayout.f187j.getHeight()).setListener(actionBarOverlayLayout.D);
                return;
        }
    }
}
