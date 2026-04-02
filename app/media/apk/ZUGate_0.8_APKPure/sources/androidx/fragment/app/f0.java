package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public final class f0 extends AnimationSet implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f875b;

    /* renamed from: c  reason: collision with root package name */
    public final View f876c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f877d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f878e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f879f;

    public f0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f879f = true;
        this.f875b = viewGroup;
        this.f876c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation) {
        this.f879f = true;
        if (this.f877d) {
            return !this.f878e;
        }
        if (!super.getTransformation(j5, transformation)) {
            this.f877d = true;
            h0.a0.a(this.f875b, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4 = this.f877d;
        ViewGroup viewGroup = this.f875b;
        if (z4 || !this.f879f) {
            viewGroup.endViewTransition(this.f876c);
            this.f878e = true;
            return;
        }
        this.f879f = false;
        viewGroup.post(this);
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation, float f5) {
        this.f879f = true;
        if (this.f877d) {
            return !this.f878e;
        }
        if (!super.getTransformation(j5, transformation, f5)) {
            this.f877d = true;
            h0.a0.a(this.f875b, this);
        }
        return true;
    }
}
