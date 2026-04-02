package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p.e;
import p.h;
import s.q;
import s.s;
/* loaded from: classes.dex */
public class Flow extends s {

    /* renamed from: p  reason: collision with root package name */
    public h f668p;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // s.s, s.c
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f668p = new h();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.f4794b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == 0) {
                    this.f668p.V0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    h hVar = this.f668p;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    hVar.f4227s0 = dimensionPixelSize;
                    hVar.f4228t0 = dimensionPixelSize;
                    hVar.f4229u0 = dimensionPixelSize;
                    hVar.f4230v0 = dimensionPixelSize;
                } else if (index == 18) {
                    h hVar2 = this.f668p;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    hVar2.f4229u0 = dimensionPixelSize2;
                    hVar2.f4231w0 = dimensionPixelSize2;
                    hVar2.f4232x0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f668p.f4230v0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f668p.f4231w0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f668p.f4227s0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f668p.f4232x0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f668p.f4228t0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f668p.T0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f668p.D0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f668p.E0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f668p.F0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f668p.H0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f668p.G0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f668p.I0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f668p.J0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f668p.L0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f668p.N0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f668p.M0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f668p.O0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f668p.K0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f668p.R0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f668p.S0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f668p.P0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f668p.Q0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f668p.U0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4647j = this.f668p;
        i();
    }

    @Override // s.c
    public final void h(e eVar, boolean z4) {
        h hVar = this.f668p;
        int i5 = hVar.f4229u0;
        if (i5 > 0 || hVar.f4230v0 > 0) {
            if (z4) {
                hVar.f4231w0 = hVar.f4230v0;
                hVar.f4232x0 = i5;
                return;
            }
            hVar.f4231w0 = i5;
            hVar.f4232x0 = hVar.f4230v0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:412:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0864  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0882  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // s.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(p.h r43, int r44, int r45) {
        /*
            Method dump skipped, instructions count: 2198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(p.h, int, int):void");
    }

    @Override // s.c, android.view.View
    public final void onMeasure(int i5, int i6) {
        j(this.f668p, i5, i6);
    }

    public void setFirstHorizontalBias(float f5) {
        this.f668p.L0 = f5;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i5) {
        this.f668p.F0 = i5;
        requestLayout();
    }

    public void setFirstVerticalBias(float f5) {
        this.f668p.M0 = f5;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i5) {
        this.f668p.G0 = i5;
        requestLayout();
    }

    public void setHorizontalAlign(int i5) {
        this.f668p.R0 = i5;
        requestLayout();
    }

    public void setHorizontalBias(float f5) {
        this.f668p.J0 = f5;
        requestLayout();
    }

    public void setHorizontalGap(int i5) {
        this.f668p.P0 = i5;
        requestLayout();
    }

    public void setHorizontalStyle(int i5) {
        this.f668p.D0 = i5;
        requestLayout();
    }

    public void setLastHorizontalBias(float f5) {
        this.f668p.N0 = f5;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i5) {
        this.f668p.H0 = i5;
        requestLayout();
    }

    public void setLastVerticalBias(float f5) {
        this.f668p.O0 = f5;
        requestLayout();
    }

    public void setLastVerticalStyle(int i5) {
        this.f668p.I0 = i5;
        requestLayout();
    }

    public void setMaxElementsWrap(int i5) {
        this.f668p.U0 = i5;
        requestLayout();
    }

    public void setOrientation(int i5) {
        this.f668p.V0 = i5;
        requestLayout();
    }

    public void setPadding(int i5) {
        h hVar = this.f668p;
        hVar.f4227s0 = i5;
        hVar.f4228t0 = i5;
        hVar.f4229u0 = i5;
        hVar.f4230v0 = i5;
        requestLayout();
    }

    public void setPaddingBottom(int i5) {
        this.f668p.f4228t0 = i5;
        requestLayout();
    }

    public void setPaddingLeft(int i5) {
        this.f668p.f4231w0 = i5;
        requestLayout();
    }

    public void setPaddingRight(int i5) {
        this.f668p.f4232x0 = i5;
        requestLayout();
    }

    public void setPaddingTop(int i5) {
        this.f668p.f4227s0 = i5;
        requestLayout();
    }

    public void setVerticalAlign(int i5) {
        this.f668p.S0 = i5;
        requestLayout();
    }

    public void setVerticalBias(float f5) {
        this.f668p.K0 = f5;
        requestLayout();
    }

    public void setVerticalGap(int i5) {
        this.f668p.Q0 = i5;
        requestLayout();
    }

    public void setVerticalStyle(int i5) {
        this.f668p.E0 = i5;
        requestLayout();
    }

    public void setWrapMode(int i5) {
        this.f668p.T0 = i5;
        requestLayout();
    }
}
