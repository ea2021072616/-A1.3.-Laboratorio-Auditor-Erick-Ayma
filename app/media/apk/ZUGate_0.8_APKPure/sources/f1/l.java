package f1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class l extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f2796a;

    /* renamed from: b  reason: collision with root package name */
    public k f2797b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f2798c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f2799d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2800e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f2801f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2802g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f2803h;

    /* renamed from: i  reason: collision with root package name */
    public int f2804i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2805j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2806k;

    /* renamed from: l  reason: collision with root package name */
    public Paint f2807l;

    public l(l lVar) {
        this.f2798c = null;
        this.f2799d = n.f2809p;
        if (lVar != null) {
            this.f2796a = lVar.f2796a;
            k kVar = new k(lVar.f2797b);
            this.f2797b = kVar;
            if (lVar.f2797b.f2786e != null) {
                kVar.f2786e = new Paint(lVar.f2797b.f2786e);
            }
            if (lVar.f2797b.f2785d != null) {
                this.f2797b.f2785d = new Paint(lVar.f2797b.f2785d);
            }
            this.f2798c = lVar.f2798c;
            this.f2799d = lVar.f2799d;
            this.f2800e = lVar.f2800e;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f2796a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new n(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new n(this);
    }

    public l() {
        this.f2798c = null;
        this.f2799d = n.f2809p;
        this.f2797b = new k();
    }
}
