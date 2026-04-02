package z0;

import java.io.Serializable;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5770c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f5771d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f5772e;

    public /* synthetic */ a(int i5, int i6, Object obj, Serializable serializable) {
        this.f5769b = i6;
        this.f5772e = obj;
        this.f5770c = i5;
        this.f5771d = serializable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f5769b;
        Object obj = this.f5771d;
        int i6 = this.f5770c;
        Object obj2 = this.f5772e;
        switch (i5) {
            case 0:
                ((b) obj2).f5775c.n(i6, obj);
                return;
            default:
                ((e) obj2).n(i6, obj);
                return;
        }
    }
}
