package com.bumptech.glide.g.a;

import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.g.a.c;
/* compiled from: ViewAnimation.java */
/* loaded from: classes.dex */
public class f<R> implements c<R> {

    /* renamed from: a  reason: collision with root package name */
    private final a f693a;

    /* compiled from: ViewAnimation.java */
    /* loaded from: classes.dex */
    interface a {
        Animation a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f693a = aVar;
    }

    @Override // com.bumptech.glide.g.a.c
    public boolean a(R r, c.a aVar) {
        View a2 = aVar.a();
        if (a2 != null) {
            a2.clearAnimation();
            a2.startAnimation(this.f693a.a());
            return false;
        }
        return false;
    }
}
