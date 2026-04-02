package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class p0 extends k0 {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f477d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f478e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f479f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f480g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f481h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f482i;

    public p0(SeekBar seekBar) {
        super(seekBar);
        this.f479f = null;
        this.f480g = null;
        this.f481h = false;
        this.f482i = false;
        this.f477d = seekBar;
    }

    @Override // androidx.appcompat.widget.k0
    public final void a(AttributeSet attributeSet, int i5) {
        super.a(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.f477d;
        Context context = seekBar.getContext();
        int[] iArr = c.a.f1690g;
        z2 m5 = z2.m(context, attributeSet, iArr, R.attr.seekBarStyle);
        h0.z0.m(seekBar, seekBar.getContext(), iArr, attributeSet, (TypedArray) m5.f606b, R.attr.seekBarStyle);
        Drawable f5 = m5.f(0);
        if (f5 != null) {
            seekBar.setThumb(f5);
        }
        Drawable e5 = m5.e(1);
        Drawable drawable = this.f478e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f478e = e5;
        if (e5 != null) {
            e5.setCallback(seekBar);
            a0.b.b(e5, seekBar.getLayoutDirection());
            if (e5.isStateful()) {
                e5.setState(seekBar.getDrawableState());
            }
            c();
        }
        seekBar.invalidate();
        if (m5.l(3)) {
            this.f480g = v1.c(m5.h(3, -1), this.f480g);
            this.f482i = true;
        }
        if (m5.l(2)) {
            this.f479f = m5.b(2);
            this.f481h = true;
        }
        m5.n();
        c();
    }

    public final void c() {
        Drawable drawable = this.f478e;
        if (drawable != null) {
            if (this.f481h || this.f482i) {
                Drawable mutate = drawable.mutate();
                this.f478e = mutate;
                if (this.f481h) {
                    a0.a.h(mutate, this.f479f);
                }
                if (this.f482i) {
                    a0.a.i(this.f478e, this.f480g);
                }
                if (this.f478e.isStateful()) {
                    this.f478e.setState(this.f477d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f478e != null) {
            SeekBar seekBar = this.f477d;
            int max = seekBar.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f478e.getIntrinsicWidth();
                int intrinsicHeight = this.f478e.getIntrinsicHeight();
                int i5 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i6 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f478e.setBounds(-i5, -i6, i5, i6);
                float width = ((seekBar.getWidth() - seekBar.getPaddingLeft()) - seekBar.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(seekBar.getPaddingLeft(), seekBar.getHeight() / 2);
                for (int i7 = 0; i7 <= max; i7++) {
                    this.f478e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
