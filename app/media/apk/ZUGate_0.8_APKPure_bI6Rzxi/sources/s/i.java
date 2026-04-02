package s;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public int f4712a;

    /* renamed from: b  reason: collision with root package name */
    public final l f4713b = new l();

    /* renamed from: c  reason: collision with root package name */
    public final k f4714c = new k();

    /* renamed from: d  reason: collision with root package name */
    public final j f4715d = new j();

    /* renamed from: e  reason: collision with root package name */
    public final m f4716e = new m();

    /* renamed from: f  reason: collision with root package name */
    public HashMap f4717f = new HashMap();

    public final void a(e eVar) {
        j jVar = this.f4715d;
        eVar.f4660e = jVar.f4733h;
        eVar.f4662f = jVar.f4735i;
        eVar.f4664g = jVar.f4737j;
        eVar.f4666h = jVar.f4739k;
        eVar.f4668i = jVar.f4741l;
        eVar.f4670j = jVar.f4743m;
        eVar.f4672k = jVar.f4745n;
        eVar.f4674l = jVar.o;
        eVar.f4676m = jVar.f4748p;
        eVar.f4678n = jVar.f4749q;
        eVar.o = jVar.f4750r;
        eVar.f4685s = jVar.f4751s;
        eVar.f4686t = jVar.f4752t;
        eVar.f4687u = jVar.f4753u;
        eVar.f4688v = jVar.f4754v;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = jVar.F;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = jVar.G;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = jVar.H;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = jVar.I;
        eVar.A = jVar.R;
        eVar.B = jVar.Q;
        eVar.f4690x = jVar.N;
        eVar.f4692z = jVar.P;
        eVar.E = jVar.f4755w;
        eVar.F = jVar.f4756x;
        eVar.f4681p = jVar.f4758z;
        eVar.f4683q = jVar.A;
        eVar.f4684r = jVar.B;
        eVar.G = jVar.f4757y;
        eVar.T = jVar.C;
        eVar.U = jVar.D;
        eVar.I = jVar.T;
        eVar.H = jVar.U;
        eVar.K = jVar.W;
        eVar.J = jVar.V;
        eVar.W = jVar.f4742l0;
        eVar.X = jVar.f4744m0;
        eVar.L = jVar.X;
        eVar.M = jVar.Y;
        eVar.P = jVar.Z;
        eVar.Q = jVar.f4720a0;
        eVar.N = jVar.f4722b0;
        eVar.O = jVar.f4724c0;
        eVar.R = jVar.f4726d0;
        eVar.S = jVar.f4728e0;
        eVar.V = jVar.E;
        eVar.f4656c = jVar.f4729f;
        eVar.f4652a = jVar.f4725d;
        eVar.f4654b = jVar.f4727e;
        ((ViewGroup.MarginLayoutParams) eVar).width = jVar.f4721b;
        ((ViewGroup.MarginLayoutParams) eVar).height = jVar.f4723c;
        String str = jVar.f4740k0;
        if (str != null) {
            eVar.Y = str;
        }
        eVar.Z = jVar.f4747o0;
        eVar.setMarginStart(jVar.K);
        eVar.setMarginEnd(jVar.J);
        eVar.a();
    }

    public final Object clone() {
        i iVar = new i();
        j jVar = iVar.f4715d;
        jVar.getClass();
        j jVar2 = this.f4715d;
        jVar.f4719a = jVar2.f4719a;
        jVar.f4721b = jVar2.f4721b;
        jVar.f4723c = jVar2.f4723c;
        jVar.f4725d = jVar2.f4725d;
        jVar.f4727e = jVar2.f4727e;
        jVar.f4729f = jVar2.f4729f;
        jVar.f4731g = jVar2.f4731g;
        jVar.f4733h = jVar2.f4733h;
        jVar.f4735i = jVar2.f4735i;
        jVar.f4737j = jVar2.f4737j;
        jVar.f4739k = jVar2.f4739k;
        jVar.f4741l = jVar2.f4741l;
        jVar.f4743m = jVar2.f4743m;
        jVar.f4745n = jVar2.f4745n;
        jVar.o = jVar2.o;
        jVar.f4748p = jVar2.f4748p;
        jVar.f4749q = jVar2.f4749q;
        jVar.f4750r = jVar2.f4750r;
        jVar.f4751s = jVar2.f4751s;
        jVar.f4752t = jVar2.f4752t;
        jVar.f4753u = jVar2.f4753u;
        jVar.f4754v = jVar2.f4754v;
        jVar.f4755w = jVar2.f4755w;
        jVar.f4756x = jVar2.f4756x;
        jVar.f4757y = jVar2.f4757y;
        jVar.f4758z = jVar2.f4758z;
        jVar.A = jVar2.A;
        jVar.B = jVar2.B;
        jVar.C = jVar2.C;
        jVar.D = jVar2.D;
        jVar.E = jVar2.E;
        jVar.F = jVar2.F;
        jVar.G = jVar2.G;
        jVar.H = jVar2.H;
        jVar.I = jVar2.I;
        jVar.J = jVar2.J;
        jVar.K = jVar2.K;
        jVar.L = jVar2.L;
        jVar.M = jVar2.M;
        jVar.N = jVar2.N;
        jVar.O = jVar2.O;
        jVar.P = jVar2.P;
        jVar.Q = jVar2.Q;
        jVar.R = jVar2.R;
        jVar.S = jVar2.S;
        jVar.T = jVar2.T;
        jVar.U = jVar2.U;
        jVar.V = jVar2.V;
        jVar.W = jVar2.W;
        jVar.X = jVar2.X;
        jVar.Y = jVar2.Y;
        jVar.Z = jVar2.Z;
        jVar.f4720a0 = jVar2.f4720a0;
        jVar.f4722b0 = jVar2.f4722b0;
        jVar.f4724c0 = jVar2.f4724c0;
        jVar.f4726d0 = jVar2.f4726d0;
        jVar.f4728e0 = jVar2.f4728e0;
        jVar.f4730f0 = jVar2.f4730f0;
        jVar.f4732g0 = jVar2.f4732g0;
        jVar.f4734h0 = jVar2.f4734h0;
        jVar.f4740k0 = jVar2.f4740k0;
        int[] iArr = jVar2.f4736i0;
        if (iArr == null || jVar2.f4738j0 != null) {
            jVar.f4736i0 = null;
        } else {
            jVar.f4736i0 = Arrays.copyOf(iArr, iArr.length);
        }
        jVar.f4738j0 = jVar2.f4738j0;
        jVar.f4742l0 = jVar2.f4742l0;
        jVar.f4744m0 = jVar2.f4744m0;
        jVar.f4746n0 = jVar2.f4746n0;
        jVar.f4747o0 = jVar2.f4747o0;
        k kVar = iVar.f4714c;
        kVar.getClass();
        k kVar2 = this.f4714c;
        kVar2.getClass();
        kVar.f4760a = kVar2.f4760a;
        kVar.f4762c = kVar2.f4762c;
        kVar.f4764e = kVar2.f4764e;
        kVar.f4763d = kVar2.f4763d;
        l lVar = iVar.f4713b;
        lVar.getClass();
        l lVar2 = this.f4713b;
        lVar2.getClass();
        lVar.f4769a = lVar2.f4769a;
        lVar.f4771c = lVar2.f4771c;
        lVar.f4772d = lVar2.f4772d;
        lVar.f4770b = lVar2.f4770b;
        m mVar = iVar.f4716e;
        mVar.getClass();
        m mVar2 = this.f4716e;
        mVar2.getClass();
        mVar.f4774a = mVar2.f4774a;
        mVar.f4775b = mVar2.f4775b;
        mVar.f4776c = mVar2.f4776c;
        mVar.f4777d = mVar2.f4777d;
        mVar.f4778e = mVar2.f4778e;
        mVar.f4779f = mVar2.f4779f;
        mVar.f4780g = mVar2.f4780g;
        mVar.f4781h = mVar2.f4781h;
        mVar.f4782i = mVar2.f4782i;
        mVar.f4783j = mVar2.f4783j;
        mVar.f4784k = mVar2.f4784k;
        mVar.f4785l = mVar2.f4785l;
        mVar.f4786m = mVar2.f4786m;
        iVar.f4712a = this.f4712a;
        return iVar;
    }
}
