package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class m0 extends RatingBar {

    /* renamed from: g  reason: collision with root package name */
    public final k0 f412g;

    public m0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        d3.a(this, getContext());
        k0 k0Var = new k0(this);
        this.f412g = k0Var;
        k0Var.a(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        Bitmap bitmap = this.f412g.f398b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i5, 0), getMeasuredHeight());
        }
    }
}
