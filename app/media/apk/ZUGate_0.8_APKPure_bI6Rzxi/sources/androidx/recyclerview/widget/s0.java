package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class s0 extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public i1 f1520a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f1521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1522c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1523d;

    public s0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1521b = new Rect();
        this.f1522c = true;
        this.f1523d = false;
    }

    public final int a() {
        return this.f1520a.c();
    }

    public final boolean b() {
        return (this.f1520a.f1385j & 2) != 0;
    }

    public final boolean c() {
        return this.f1520a.i();
    }

    public s0(int i5, int i6) {
        super(i5, i6);
        this.f1521b = new Rect();
        this.f1522c = true;
        this.f1523d = false;
    }

    public s0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1521b = new Rect();
        this.f1522c = true;
        this.f1523d = false;
    }

    public s0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f1521b = new Rect();
        this.f1522c = true;
        this.f1523d = false;
    }

    public s0(s0 s0Var) {
        super((ViewGroup.LayoutParams) s0Var);
        this.f1521b = new Rect();
        this.f1522c = true;
        this.f1523d = false;
    }
}
