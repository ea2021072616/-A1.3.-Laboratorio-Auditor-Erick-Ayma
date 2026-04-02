package com.bumptech.glide.g.b;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* compiled from: SquaringDrawable.java */
/* loaded from: classes.dex */
public class i extends com.bumptech.glide.load.resource.a.b {

    /* renamed from: a  reason: collision with root package name */
    private com.bumptech.glide.load.resource.a.b f698a;

    /* renamed from: b  reason: collision with root package name */
    private a f699b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f700c;

    public i(com.bumptech.glide.load.resource.a.b bVar, int i) {
        this(new a(bVar.getConstantState(), i), bVar, null);
    }

    i(a aVar, com.bumptech.glide.load.resource.a.b bVar, Resources resources) {
        this.f699b = aVar;
        if (bVar == null) {
            if (resources != null) {
                this.f698a = (com.bumptech.glide.load.resource.a.b) aVar.f701a.newDrawable(resources);
                return;
            } else {
                this.f698a = (com.bumptech.glide.load.resource.a.b) aVar.f701a.newDrawable();
                return;
            }
        }
        this.f698a = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f698a.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f698a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f698a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f698a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f698a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f698a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(11)
    public Drawable.Callback getCallback() {
        return this.f698a.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public int getAlpha() {
        return this.f698a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.f698a.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f698a.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f698a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f698a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f699b.f702b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f699b.f702b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f698a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f698a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f698a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f698a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f698a.unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f698a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f698a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f698a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f698a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f698a.getOpacity();
    }

    @Override // com.bumptech.glide.load.resource.a.b
    public boolean a() {
        return this.f698a.a();
    }

    @Override // com.bumptech.glide.load.resource.a.b
    public void a(int i) {
        this.f698a.a(i);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f698a.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f698a.stop();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f698a.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f700c && super.mutate() == this) {
            this.f698a = (com.bumptech.glide.load.resource.a.b) this.f698a.mutate();
            this.f699b = new a(this.f699b);
            this.f700c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f699b;
    }

    /* compiled from: SquaringDrawable.java */
    /* loaded from: classes.dex */
    static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f701a;

        /* renamed from: b  reason: collision with root package name */
        private final int f702b;

        a(a aVar) {
            this(aVar.f701a, aVar.f702b);
        }

        a(Drawable.ConstantState constantState, int i) {
            this.f701a = constantState;
            this.f702b = i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this, null, resources);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
