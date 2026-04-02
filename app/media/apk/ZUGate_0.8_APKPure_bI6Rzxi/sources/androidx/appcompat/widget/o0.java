package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class o0 extends SeekBar {

    /* renamed from: g  reason: collision with root package name */
    public final p0 f436g;

    public o0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        d3.a(this, getContext());
        p0 p0Var = new p0(this);
        this.f436g = p0Var;
        p0Var.a(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        p0 p0Var = this.f436g;
        Drawable drawable = p0Var.f478e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        SeekBar seekBar = p0Var.f477d;
        if (drawable.setState(seekBar.getDrawableState())) {
            seekBar.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f436g.f478e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f436g.d(canvas);
    }
}
