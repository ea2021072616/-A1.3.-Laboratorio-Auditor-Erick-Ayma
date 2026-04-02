package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: n  reason: collision with root package name */
    public int f4635n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public p.a f4636p;

    public a(Context context) {
        super(context);
        setVisibility(8);
    }

    @Override // s.c
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f4636p = new p.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.f4794b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == 26) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f4636p.f4121t0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f4636p.f4122u0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4647j = this.f4636p;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f4636p.f4121t0;
    }

    public int getMargin() {
        return this.f4636p.f4122u0;
    }

    public int getType() {
        return this.f4635n;
    }

    @Override // s.c
    public final void h(p.e eVar, boolean z4) {
        int i5 = this.f4635n;
        this.o = i5;
        if (z4) {
            if (i5 == 5) {
                this.o = 1;
            } else if (i5 == 6) {
                this.o = 0;
            }
        } else if (i5 == 5) {
            this.o = 0;
        } else if (i5 == 6) {
            this.o = 1;
        }
        if (eVar instanceof p.a) {
            ((p.a) eVar).f4120s0 = this.o;
        }
    }

    public void setAllowsGoneWidget(boolean z4) {
        this.f4636p.f4121t0 = z4;
    }

    public void setDpMargin(int i5) {
        this.f4636p.f4122u0 = (int) ((i5 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i5) {
        this.f4636p.f4122u0 = i5;
    }

    public void setType(int i5) {
        this.f4635n = i5;
    }
}
