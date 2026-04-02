package s;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public abstract class s extends c {

    /* renamed from: n  reason: collision with root package name */
    public boolean f4803n;
    public boolean o;

    @Override // s.c
    public final void e(ConstraintLayout constraintLayout) {
        d(constraintLayout);
    }

    @Override // s.c
    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.f4794b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == 6) {
                    this.f4803n = true;
                } else if (index == 22) {
                    this.o = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public abstract void j(p.h hVar, int i5, int i6);

    @Override // s.c, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4803n || this.o) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i5 = 0; i5 < this.f4645h; i5++) {
                    View view = (View) constraintLayout.f670g.get(this.f4644g[i5]);
                    if (view != null) {
                        if (this.f4803n) {
                            view.setVisibility(visibility);
                        }
                        if (this.o && elevation > 0.0f) {
                            view.setTranslationZ(view.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        d((ConstraintLayout) parent);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        d((ConstraintLayout) parent);
    }
}
