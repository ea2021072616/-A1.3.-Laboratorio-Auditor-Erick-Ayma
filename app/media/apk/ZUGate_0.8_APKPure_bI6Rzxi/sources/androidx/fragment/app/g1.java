package androidx.fragment.app;

import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: b  reason: collision with root package name */
    public int f895b;

    /* renamed from: c  reason: collision with root package name */
    public int f896c;

    /* renamed from: d  reason: collision with root package name */
    public int f897d;

    /* renamed from: e  reason: collision with root package name */
    public int f898e;

    /* renamed from: f  reason: collision with root package name */
    public int f899f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f900g;

    /* renamed from: i  reason: collision with root package name */
    public String f902i;

    /* renamed from: j  reason: collision with root package name */
    public int f903j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f904k;

    /* renamed from: l  reason: collision with root package name */
    public int f905l;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence f906m;

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f907n;
    public ArrayList o;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f894a = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public boolean f901h = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f908p = false;

    public final void b(f1 f1Var) {
        this.f894a.add(f1Var);
        f1Var.f883d = this.f895b;
        f1Var.f884e = this.f896c;
        f1Var.f885f = this.f897d;
        f1Var.f886g = this.f898e;
    }

    public abstract void c(int i5, Fragment fragment, String str, int i6);

    public abstract a d(Fragment fragment, androidx.lifecycle.n nVar);
}
