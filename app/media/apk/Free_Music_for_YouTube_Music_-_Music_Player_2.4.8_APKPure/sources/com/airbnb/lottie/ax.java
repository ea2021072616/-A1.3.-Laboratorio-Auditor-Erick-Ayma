package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.av;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class ax extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f421a = ax.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private aw f423c;
    @Nullable
    private an i;
    @Nullable
    private String j;
    @Nullable
    private ao k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    @Nullable
    private v p;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f422b = new Matrix();
    private final ValueAnimator d = ValueAnimator.ofFloat(0.0f, 1.0f);
    private float e = 1.0f;
    private float f = 1.0f;
    private float g = 0.0f;
    private final Set<a> h = new HashSet();
    private int q = 255;

    public ax() {
        this.d.setRepeatCount(0);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.ax.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ax.this.n) {
                    ax.this.d.cancel();
                    ax.this.b(1.0f);
                    return;
                }
                ax.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.o;
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(f421a, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.o = z;
        if (this.f423c != null) {
            m();
        }
    }

    public void a(@Nullable String str) {
        this.j = str;
    }

    @Nullable
    public String b() {
        return this.j;
    }

    public void c() {
        if (this.i != null) {
            this.i.a();
        }
    }

    public boolean a(aw awVar) {
        if (getCallback() == null) {
            throw new IllegalStateException("You or your view must set a Drawable.Callback before setting the composition. This gets done automatically when added to an ImageView. Either call ImageView.setImageDrawable() before setComposition() or call setCallback(yourView.getCallback()) first.");
        }
        if (this.f423c == awVar) {
            return false;
        }
        o();
        this.f423c = awVar;
        a(this.e);
        c(1.0f);
        p();
        m();
        n();
        b(this.g);
        if (this.l) {
            this.l = false;
            g();
        }
        if (this.m) {
            this.m = false;
            h();
        }
        return true;
    }

    private void m() {
        this.p = new v(this, av.a.a(this.f423c), this.f423c.d(), this.f423c);
    }

    private void n() {
        if (this.p != null) {
            for (a aVar : this.h) {
                this.p.a(aVar.f425a, aVar.f426b, aVar.f427c);
            }
        }
    }

    private void o() {
        c();
        this.p = null;
        this.i = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.q = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void a(ColorFilter colorFilter) {
        a(null, null, colorFilter);
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        a aVar = new a(str, str2, colorFilter);
        if (colorFilter == null && this.h.contains(aVar)) {
            this.h.remove(aVar);
        } else {
            this.h.add(new a(str, str2, colorFilter));
        }
        if (this.p != null) {
            this.p.a(str, str2, colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.p != null) {
            float f = this.f;
            if (this.p.f()) {
                f = Math.min(this.f, a(canvas));
            }
            this.f422b.reset();
            this.f422b.preScale(f, f);
            this.p.a(canvas, this.f422b, this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.n = true;
    }

    public void b(boolean z) {
        this.d.setRepeatCount(z ? -1 : 0);
    }

    public boolean e() {
        return this.d.getRepeatCount() == -1;
    }

    public boolean f() {
        return this.d.isRunning();
    }

    public void g() {
        c(((double) this.g) > 0.0d && ((double) this.g) < 1.0d);
    }

    private void c(boolean z) {
        if (this.p == null) {
            this.l = true;
            this.m = false;
            return;
        }
        if (z) {
            this.d.setCurrentPlayTime(this.g * ((float) this.d.getDuration()));
        }
        this.d.start();
    }

    public void h() {
        d(((double) this.g) > 0.0d && ((double) this.g) < 1.0d);
    }

    private void d(boolean z) {
        if (this.p == null) {
            this.l = false;
            this.m = true;
            return;
        }
        if (z) {
            this.d.setCurrentPlayTime(this.g * ((float) this.d.getDuration()));
        }
        this.d.reverse();
    }

    public void a(float f) {
        this.e = f;
        if (f < 0.0f) {
            this.d.setFloatValues(1.0f, 0.0f);
        } else {
            this.d.setFloatValues(0.0f, 1.0f);
        }
        if (this.f423c != null) {
            this.d.setDuration(((float) this.f423c.b()) / Math.abs(f));
        }
    }

    public void b(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.g = f;
        if (this.p != null) {
            this.p.a(f);
        }
    }

    public float i() {
        return this.g;
    }

    public void c(float f) {
        this.f = f;
        p();
    }

    public void a(ao aoVar) {
        this.k = aoVar;
        if (this.i != null) {
            this.i.a(aoVar);
        }
    }

    public float j() {
        return this.f;
    }

    public aw k() {
        return this.f423c;
    }

    private void p() {
        if (this.f423c != null) {
            setBounds(0, 0, (int) (this.f423c.a().width() * this.f), (int) (this.f423c.a().height() * this.f));
        }
    }

    public void l() {
        this.l = false;
        this.m = false;
        this.d.cancel();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.d.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.d.removeListener(animatorListener);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f423c == null) {
            return -1;
        }
        return (int) (this.f423c.a().width() * this.f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f423c == null) {
            return -1;
        }
        return (int) (this.f423c.a().height() * this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Bitmap b(String str) {
        return q().a(str);
    }

    private an q() {
        if (this.i != null && !this.i.a(r())) {
            this.i.a();
            this.i = null;
        }
        if (this.i == null) {
            this.i = new an(getCallback(), this.j, this.k, this.f423c.e());
        }
        return this.i;
    }

    @Nullable
    private Context r() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private float a(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f423c.a().width(), canvas.getHeight() / this.f423c.a().height());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f425a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        final String f426b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        final ColorFilter f427c;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.f425a = str;
            this.f426b = str2;
            this.f427c = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.f425a != null) {
                i = this.f425a.hashCode() * 527;
            }
            if (this.f426b != null) {
                return i * 31 * this.f426b.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.f427c == aVar.f427c;
            }
            return false;
        }
    }
}
