package androidx.fragment.app;
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a  reason: collision with root package name */
    public int f880a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f881b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f882c;

    /* renamed from: d  reason: collision with root package name */
    public int f883d;

    /* renamed from: e  reason: collision with root package name */
    public int f884e;

    /* renamed from: f  reason: collision with root package name */
    public int f885f;

    /* renamed from: g  reason: collision with root package name */
    public int f886g;

    /* renamed from: h  reason: collision with root package name */
    public androidx.lifecycle.n f887h;

    /* renamed from: i  reason: collision with root package name */
    public androidx.lifecycle.n f888i;

    public f1(Fragment fragment, int i5) {
        this.f880a = i5;
        this.f881b = fragment;
        this.f882c = false;
        androidx.lifecycle.n nVar = androidx.lifecycle.n.RESUMED;
        this.f887h = nVar;
        this.f888i = nVar;
    }

    public f1(int i5, Fragment fragment) {
        this.f880a = i5;
        this.f881b = fragment;
        this.f882c = true;
        androidx.lifecycle.n nVar = androidx.lifecycle.n.RESUMED;
        this.f887h = nVar;
        this.f888i = nVar;
    }

    public f1(Fragment fragment, androidx.lifecycle.n nVar) {
        this.f880a = 10;
        this.f881b = fragment;
        this.f882c = false;
        this.f887h = fragment.mMaxState;
        this.f888i = nVar;
    }
}
