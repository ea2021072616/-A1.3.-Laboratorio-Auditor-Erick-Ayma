package com.bumptech.glide.g.a;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.bumptech.glide.g.a.f;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class a<T extends Drawable> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final g<T> f685a;

    /* renamed from: b  reason: collision with root package name */
    private final int f686b;

    /* renamed from: c  reason: collision with root package name */
    private b<T> f687c;
    private b<T> d;

    public a() {
        this(IjkMediaCodecInfo.RANK_SECURE);
    }

    public a(int i) {
        this(new g(new C0022a(i)), i);
    }

    a(g<T> gVar, int i) {
        this.f685a = gVar;
        this.f686b = i;
    }

    @Override // com.bumptech.glide.g.a.d
    public c<T> a(boolean z, boolean z2) {
        if (z) {
            return e.b();
        }
        if (z2) {
            return a();
        }
        return b();
    }

    private c<T> a() {
        if (this.f687c == null) {
            this.f687c = new b<>(this.f685a.a(false, true), this.f686b);
        }
        return this.f687c;
    }

    private c<T> b() {
        if (this.d == null) {
            this.d = new b<>(this.f685a.a(false, false), this.f686b);
        }
        return this.d;
    }

    /* compiled from: DrawableCrossFadeFactory.java */
    /* renamed from: com.bumptech.glide.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0022a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f688a;

        C0022a(int i) {
            this.f688a = i;
        }

        @Override // com.bumptech.glide.g.a.f.a
        public Animation a() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.f688a);
            return alphaAnimation;
        }
    }
}
