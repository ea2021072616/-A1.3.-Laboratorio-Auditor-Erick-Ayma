package androidx.recyclerview.widget;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: a  reason: collision with root package name */
    public int f1423a;

    /* renamed from: b  reason: collision with root package name */
    public int f1424b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1425c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1426d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1427e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f1428f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f1429g;

    public m1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f1429g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f1423a = -1;
        this.f1424b = Integer.MIN_VALUE;
        this.f1425c = false;
        this.f1426d = false;
        this.f1427e = false;
        int[] iArr = this.f1428f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
