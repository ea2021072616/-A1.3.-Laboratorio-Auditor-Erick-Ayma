package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public int f1419a;

    /* renamed from: b  reason: collision with root package name */
    public int f1420b;

    /* renamed from: c  reason: collision with root package name */
    public int f1421c;

    /* renamed from: d  reason: collision with root package name */
    public int f1422d;

    public m0(int i5, int i6, int i7, int i8) {
        this.f1419a = i5;
        this.f1420b = i6;
        this.f1421c = i7;
        this.f1422d = i8;
    }

    public final void a(i1 i1Var) {
        View view = i1Var.f1376a;
        this.f1419a = view.getLeft();
        this.f1420b = view.getTop();
        this.f1421c = view.getRight();
        this.f1422d = view.getBottom();
    }
}
