package c3;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.github.appintro.R;
import com.google.android.material.button.MaterialButton;
import e4.e;
import h0.z0;
import java.util.WeakHashMap;
import p3.f;
import p3.g;
import p3.j;
import p3.u;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialButton f1765a;

    /* renamed from: b  reason: collision with root package name */
    public j f1766b;

    /* renamed from: c  reason: collision with root package name */
    public int f1767c;

    /* renamed from: d  reason: collision with root package name */
    public int f1768d;

    /* renamed from: e  reason: collision with root package name */
    public int f1769e;

    /* renamed from: f  reason: collision with root package name */
    public int f1770f;

    /* renamed from: g  reason: collision with root package name */
    public int f1771g;

    /* renamed from: h  reason: collision with root package name */
    public int f1772h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f1773i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f1774j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f1775k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f1776l;

    /* renamed from: m  reason: collision with root package name */
    public g f1777m;

    /* renamed from: q  reason: collision with root package name */
    public boolean f1780q;

    /* renamed from: s  reason: collision with root package name */
    public RippleDrawable f1782s;

    /* renamed from: t  reason: collision with root package name */
    public int f1783t;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1778n = false;
    public boolean o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1779p = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1781r = true;

    public c(MaterialButton materialButton, j jVar) {
        this.f1765a = materialButton;
        this.f1766b = jVar;
    }

    public final u a() {
        RippleDrawable rippleDrawable = this.f1782s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f1782s.getNumberOfLayers() > 2 ? (u) this.f1782s.getDrawable(2) : (u) this.f1782s.getDrawable(1);
    }

    public final g b(boolean z4) {
        RippleDrawable rippleDrawable = this.f1782s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) ((LayerDrawable) ((InsetDrawable) this.f1782s.getDrawable(0)).getDrawable()).getDrawable(!z4 ? 1 : 0);
    }

    public final void c(j jVar) {
        this.f1766b = jVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(jVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(jVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }

    public final void d(int i5, int i6) {
        WeakHashMap weakHashMap = z0.f3233a;
        MaterialButton materialButton = this.f1765a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i7 = this.f1769e;
        int i8 = this.f1770f;
        this.f1770f = i6;
        this.f1769e = i5;
        if (!this.o) {
            e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i5) - i7, paddingEnd, (paddingBottom + i6) - i8);
    }

    public final void e() {
        g gVar = new g(this.f1766b);
        MaterialButton materialButton = this.f1765a;
        gVar.h(materialButton.getContext());
        a0.a.h(gVar, this.f1774j);
        PorterDuff.Mode mode = this.f1773i;
        if (mode != null) {
            a0.a.i(gVar, mode);
        }
        ColorStateList colorStateList = this.f1775k;
        gVar.f4294g.f4284k = this.f1772h;
        gVar.invalidateSelf();
        f fVar = gVar.f4294g;
        if (fVar.f4277d != colorStateList) {
            fVar.f4277d = colorStateList;
            gVar.onStateChange(gVar.getState());
        }
        g gVar2 = new g(this.f1766b);
        gVar2.setTint(0);
        float f5 = this.f1772h;
        int l5 = this.f1778n ? e.l(materialButton, R.attr.colorSurface) : 0;
        gVar2.f4294g.f4284k = f5;
        gVar2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(l5);
        f fVar2 = gVar2.f4294g;
        if (fVar2.f4277d != valueOf) {
            fVar2.f4277d = valueOf;
            gVar2.onStateChange(gVar2.getState());
        }
        g gVar3 = new g(this.f1766b);
        this.f1777m = gVar3;
        a0.a.g(gVar3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(n3.a.a(this.f1776l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.f1767c, this.f1769e, this.f1768d, this.f1770f), this.f1777m);
        this.f1782s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        g b5 = b(false);
        if (b5 != null) {
            b5.i(this.f1783t);
            b5.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        g b5 = b(false);
        g b6 = b(true);
        if (b5 != null) {
            ColorStateList colorStateList = this.f1775k;
            b5.f4294g.f4284k = this.f1772h;
            b5.invalidateSelf();
            f fVar = b5.f4294g;
            if (fVar.f4277d != colorStateList) {
                fVar.f4277d = colorStateList;
                b5.onStateChange(b5.getState());
            }
            if (b6 != null) {
                float f5 = this.f1772h;
                int l5 = this.f1778n ? e.l(this.f1765a, R.attr.colorSurface) : 0;
                b6.f4294g.f4284k = f5;
                b6.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(l5);
                f fVar2 = b6.f4294g;
                if (fVar2.f4277d != valueOf) {
                    fVar2.f4277d = valueOf;
                    b6.onStateChange(b6.getState());
                }
            }
        }
    }
}
