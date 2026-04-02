package com.fotoable.youtube.music.d;
/* compiled from: RxPresenter.java */
/* loaded from: classes.dex */
public class aq<T> {

    /* renamed from: c  reason: collision with root package name */
    protected rx.g.b f2510c;

    /* JADX INFO: Access modifiers changed from: protected */
    public void b_() {
        if (this.f2510c != null) {
            this.f2510c.unsubscribe();
            this.f2510c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(rx.m mVar) {
        if (this.f2510c == null) {
            this.f2510c = new rx.g.b();
        }
        this.f2510c.a(mVar);
    }
}
