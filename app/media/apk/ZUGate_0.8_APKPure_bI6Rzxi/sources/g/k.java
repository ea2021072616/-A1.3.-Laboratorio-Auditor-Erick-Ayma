package g;

import androidx.appcompat.widget.p3;
import com.google.android.gms.internal.play_billing.i0;
import h0.l1;
/* loaded from: classes.dex */
public final class k extends i0 {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f2917l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2918m;

    /* renamed from: n  reason: collision with root package name */
    public int f2919n;
    public final /* synthetic */ Object o;

    public k(l lVar) {
        this.f2917l = 0;
        this.o = lVar;
        this.f2918m = false;
        this.f2919n = 0;
    }

    @Override // h0.l1
    public final void a() {
        int i5 = this.f2917l;
        Object obj = this.o;
        switch (i5) {
            case 0:
                int i6 = this.f2919n + 1;
                this.f2919n = i6;
                l lVar = (l) obj;
                if (i6 == lVar.f2920a.size()) {
                    l1 l1Var = lVar.f2923d;
                    if (l1Var != null) {
                        l1Var.a();
                    }
                    this.f2919n = 0;
                    this.f2918m = false;
                    lVar.f2924e = false;
                    return;
                }
                return;
            default:
                if (this.f2918m) {
                    return;
                }
                ((p3) obj).f486a.setVisibility(this.f2919n);
                return;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.i0, h0.l1
    public final void b() {
        switch (this.f2917l) {
            case 1:
                this.f2918m = true;
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.i0, h0.l1
    public final void c() {
        int i5 = this.f2917l;
        Object obj = this.o;
        switch (i5) {
            case 0:
                if (this.f2918m) {
                    return;
                }
                this.f2918m = true;
                l1 l1Var = ((l) obj).f2923d;
                if (l1Var != null) {
                    l1Var.c();
                    return;
                }
                return;
            default:
                ((p3) obj).f486a.setVisibility(0);
                return;
        }
    }

    public k(p3 p3Var, int i5) {
        this.f2917l = 1;
        this.o = p3Var;
        this.f2919n = i5;
        this.f2918m = false;
    }
}
