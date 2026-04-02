package f1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import y.q;
/* loaded from: classes.dex */
public final class d extends e implements Animatable {

    /* renamed from: h  reason: collision with root package name */
    public final b f2749h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f2750i;

    /* renamed from: j  reason: collision with root package name */
    public androidx.appcompat.widget.d f2751j = null;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f2752k = null;

    /* renamed from: l  reason: collision with root package name */
    public final e.a f2753l;

    public d(Context context) {
        e.a aVar = new e.a(this);
        this.f2753l = aVar;
        this.f2750i = context;
        this.f2749h = new b(aVar);
    }

    @Override // f1.e, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            return a0.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        b bVar = this.f2749h;
        bVar.f2744a.draw(canvas);
        if (bVar.f2745b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getAlpha() : this.f2749h.f2744a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f2749h.getClass();
        return changingConfigurations | 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f2754g;
        return drawable != null ? a0.a.c(drawable) : this.f2749h.f2744a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f2754g != null) {
            return new c(this.f2754g.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2749h.f2744a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2749h.f2744a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getOpacity() : this.f2749h.f2744a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar;
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            bVar = this.f2749h;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray t5 = m0.a.t(resources, theme, attributeSet, b4.j.f1671j);
                    int resourceId = t5.getResourceId(0, 0);
                    if (resourceId != 0) {
                        n nVar = new n();
                        ThreadLocal threadLocal = q.f5568a;
                        nVar.f2754g = y.i.a(resources, resourceId, theme);
                        new m(nVar.f2754g.getConstantState());
                        nVar.f2814l = false;
                        nVar.setCallback(this.f2753l);
                        n nVar2 = bVar.f2744a;
                        if (nVar2 != null) {
                            nVar2.setCallback(null);
                        }
                        bVar.f2744a = nVar;
                    }
                    t5.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, b4.j.f1672k);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2750i;
                        if (context != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, resourceId2);
                            loadAnimator.setTarget(bVar.f2744a.f2810h.f2797b.o.getOrDefault(string, null));
                            if (bVar.f2746c == null) {
                                bVar.f2746c = new ArrayList();
                                bVar.f2747d = new l.b();
                            }
                            bVar.f2746c.add(loadAnimator);
                            bVar.f2747d.put(loadAnimator, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        if (bVar.f2745b == null) {
            bVar.f2745b = new AnimatorSet();
        }
        bVar.f2745b.playTogether(bVar.f2746c);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.isAutoMirrored() : this.f2749h.f2744a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f2754g;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2749h.f2745b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.isStateful() : this.f2749h.f2744a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2749h.f2744a.setBounds(rect);
        }
    }

    @Override // f1.e, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i5) {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.setLevel(i5) : this.f2749h.f2744a.setLevel(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.setState(iArr) : this.f2749h.f2744a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else {
            this.f2749h.f2744a.setAlpha(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setAutoMirrored(z4);
        } else {
            this.f2749h.f2744a.setAutoMirrored(z4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2749h.f2744a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            p2.a.V(drawable, i5);
        } else {
            this.f2749h.f2744a.setTint(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            p2.a.W(drawable, colorStateList);
        } else {
            this.f2749h.f2744a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            p2.a.X(drawable, mode);
        } else {
            this.f2749h.f2744a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            return drawable.setVisible(z4, z5);
        }
        this.f2749h.f2744a.setVisible(z4, z5);
        return super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        b bVar = this.f2749h;
        if (bVar.f2745b.isStarted()) {
            return;
        }
        bVar.f2745b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2749h.f2745b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
