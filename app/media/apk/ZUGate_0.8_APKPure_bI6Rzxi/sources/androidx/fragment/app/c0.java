package androidx.fragment.app;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public final class c0 extends i0 implements x.c, x.d, w.e0, w.f0, androidx.lifecycle.w0, androidx.activity.a0, androidx.activity.result.i, b1.f, a1, h0.m {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d0 f839k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d.q qVar) {
        super(qVar);
        this.f839k = qVar;
    }

    @Override // androidx.fragment.app.a1
    public final void a(Fragment fragment) {
        this.f839k.onAttachFragment(fragment);
    }

    @Override // h0.m
    public final void addMenuProvider(h0.s sVar) {
        this.f839k.addMenuProvider(sVar);
    }

    @Override // x.c
    public final void addOnConfigurationChangedListener(g0.a aVar) {
        this.f839k.addOnConfigurationChangedListener(aVar);
    }

    @Override // w.e0
    public final void addOnMultiWindowModeChangedListener(g0.a aVar) {
        this.f839k.addOnMultiWindowModeChangedListener(aVar);
    }

    @Override // w.f0
    public final void addOnPictureInPictureModeChangedListener(g0.a aVar) {
        this.f839k.addOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // x.d
    public final void addOnTrimMemoryListener(g0.a aVar) {
        this.f839k.addOnTrimMemoryListener(aVar);
    }

    @Override // androidx.fragment.app.g0
    public final View b(int i5) {
        return this.f839k.findViewById(i5);
    }

    @Override // androidx.fragment.app.g0
    public final boolean c() {
        Window window = this.f839k.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.activity.result.i
    public final androidx.activity.result.h getActivityResultRegistry() {
        return this.f839k.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.t
    public final androidx.lifecycle.o getLifecycle() {
        return this.f839k.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.a0
    public final androidx.activity.z getOnBackPressedDispatcher() {
        return this.f839k.getOnBackPressedDispatcher();
    }

    @Override // b1.f
    public final b1.d getSavedStateRegistry() {
        return this.f839k.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.w0
    public final androidx.lifecycle.v0 getViewModelStore() {
        return this.f839k.getViewModelStore();
    }

    @Override // h0.m
    public final void removeMenuProvider(h0.s sVar) {
        this.f839k.removeMenuProvider(sVar);
    }

    @Override // x.c
    public final void removeOnConfigurationChangedListener(g0.a aVar) {
        this.f839k.removeOnConfigurationChangedListener(aVar);
    }

    @Override // w.e0
    public final void removeOnMultiWindowModeChangedListener(g0.a aVar) {
        this.f839k.removeOnMultiWindowModeChangedListener(aVar);
    }

    @Override // w.f0
    public final void removeOnPictureInPictureModeChangedListener(g0.a aVar) {
        this.f839k.removeOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // x.d
    public final void removeOnTrimMemoryListener(g0.a aVar) {
        this.f839k.removeOnTrimMemoryListener(aVar);
    }
}
