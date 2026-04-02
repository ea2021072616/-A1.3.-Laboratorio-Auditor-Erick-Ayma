package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import s.e;
/* loaded from: classes.dex */
public class Guideline extends View {

    /* renamed from: g  reason: collision with root package name */
    public boolean f684g;

    public Guideline(Context context) {
        super(context);
        this.f684g = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z4) {
        this.f684g = z4;
    }

    public void setGuidelineBegin(int i5) {
        e eVar = (e) getLayoutParams();
        if (this.f684g && eVar.f4652a == i5) {
            return;
        }
        eVar.f4652a = i5;
        setLayoutParams(eVar);
    }

    public void setGuidelineEnd(int i5) {
        e eVar = (e) getLayoutParams();
        if (this.f684g && eVar.f4654b == i5) {
            return;
        }
        eVar.f4654b = i5;
        setLayoutParams(eVar);
    }

    public void setGuidelinePercent(float f5) {
        e eVar = (e) getLayoutParams();
        if (this.f684g && eVar.f4656c == f5) {
            return;
        }
        eVar.f4656c = f5;
        setLayoutParams(eVar);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f684g = true;
        super.setVisibility(8);
    }
}
