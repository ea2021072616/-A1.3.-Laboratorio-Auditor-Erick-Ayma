package t4;

import ru.zdevs.zugate.MainActivity;
/* loaded from: classes.dex */
public final class f extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ a f5052u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f5053v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ y4.j f5054w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ MainActivity f5055x;

    public f(int i5, a aVar, MainActivity mainActivity, y4.j jVar) {
        this.f5055x = mainActivity;
        this.f5052u = aVar;
        this.f5053v = i5;
        this.f5054w = jVar;
    }

    @Override // p2.a
    public final void J(int i5) {
        if (i5 == 13) {
            a aVar = this.f5052u;
            this.f5055x.i(1, aVar, this.f5053v | 512);
        }
    }

    @Override // p2.a
    public final void K() {
        y4.j jVar = this.f5054w;
        if (jVar != null) {
            int i5 = MainActivity.f4551q;
            int i6 = this.f5053v;
            a aVar = this.f5052u;
            MainActivity mainActivity = this.f5055x;
            mainActivity.getClass();
            new o(mainActivity.f4554i, mainActivity.f4552g, 1, aVar, jVar, i6).b(mainActivity, mainActivity.f4555j);
        }
    }
}
