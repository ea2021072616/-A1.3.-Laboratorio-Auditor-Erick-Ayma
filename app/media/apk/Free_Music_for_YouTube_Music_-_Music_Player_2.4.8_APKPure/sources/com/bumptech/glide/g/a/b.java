package com.bumptech.glide.g.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.g.a.c;
/* compiled from: DrawableCrossFadeViewAnimation.java */
/* loaded from: classes.dex */
public class b<T extends Drawable> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f689a;

    /* renamed from: b  reason: collision with root package name */
    private final int f690b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.g.a.c
    public /* bridge */ /* synthetic */ boolean a(Object obj, c.a aVar) {
        return a((b<T>) ((Drawable) obj), aVar);
    }

    public b(c<T> cVar, int i) {
        this.f689a = cVar;
        this.f690b = i;
    }

    public boolean a(T t, c.a aVar) {
        Drawable b2 = aVar.b();
        if (b2 != null) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{b2, t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.f690b);
            aVar.a(transitionDrawable);
            return true;
        }
        this.f689a.a(t, aVar);
        return false;
    }
}
