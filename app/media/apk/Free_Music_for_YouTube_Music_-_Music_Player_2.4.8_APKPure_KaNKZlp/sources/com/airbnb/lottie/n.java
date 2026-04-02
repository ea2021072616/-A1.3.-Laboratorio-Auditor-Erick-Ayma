package com.airbnb.lottie;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
abstract class n<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends at<K>> f539c;
    @Nullable
    private at<K> e;

    /* renamed from: a  reason: collision with root package name */
    final List<a> f537a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f538b = false;
    private float d = 0.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    interface a {
        void a();
    }

    abstract A a(at<K> atVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<? extends at<K>> list) {
        this.f539c = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f538b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f537a.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < f()) {
            f = 0.0f;
        } else if (f > g()) {
            f = 1.0f;
        }
        if (f != this.d) {
            this.d = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f537a.size()) {
                    this.f537a.get(i2).a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private at<K> d() {
        if (this.f539c.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.e != null && this.e.a(this.d)) {
            return this.e;
        }
        at<K> atVar = this.f539c.get(0);
        if (this.d < atVar.a()) {
            this.e = atVar;
            return atVar;
        }
        for (int i = 0; !atVar.a(this.d) && i < this.f539c.size(); i++) {
            atVar = this.f539c.get(i);
        }
        this.e = atVar;
        return atVar;
    }

    private float e() {
        if (this.f538b) {
            return 0.0f;
        }
        at<K> d = d();
        if (d.c()) {
            return 0.0f;
        }
        return d.f408c.getInterpolation((this.d - d.a()) / (d.b() - d.a()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float f() {
        if (this.f539c.isEmpty()) {
            return 0.0f;
        }
        return this.f539c.get(0).a();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float g() {
        if (this.f539c.isEmpty()) {
            return 1.0f;
        }
        return this.f539c.get(this.f539c.size() - 1).b();
    }

    public A b() {
        return a(d(), e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.d;
    }
}
