package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class m extends h0 implements o {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ n f411j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f411j = nVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        q3.a(this, getContentDescription());
        setOnTouchListener(new l(this, this, nVar, 0));
    }

    @Override // androidx.appcompat.widget.o
    public final boolean a() {
        return false;
    }

    @Override // androidx.appcompat.widget.o
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f411j.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i5, int i6, int i7, int i8) {
        boolean frame = super.setFrame(i5, i6, i7, i8);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            a0.a.f(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
