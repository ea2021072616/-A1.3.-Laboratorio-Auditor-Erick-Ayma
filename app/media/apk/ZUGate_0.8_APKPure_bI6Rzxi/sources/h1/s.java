package h1;

import com.google.android.gms.internal.play_billing.i2;
import com.google.android.gms.internal.play_billing.j2;
import com.google.android.gms.internal.play_billing.l2;
import com.google.android.gms.internal.play_billing.m2;
import com.google.android.gms.internal.play_billing.n2;
import com.google.android.gms.internal.play_billing.p2;
/* loaded from: classes.dex */
public abstract /* synthetic */ class s {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f3316a = 0;

    static {
        int i5 = t.f3317f;
    }

    public static j2 a(int i5, int i6, g gVar) {
        try {
            i2 p5 = j2.p();
            n2 q5 = p2.q();
            int i7 = gVar.f3283b;
            q5.c();
            p2.m((p2) q5.f1903c, i7);
            String str = gVar.f3284c;
            q5.c();
            p2.n((p2) q5.f1903c, str);
            q5.c();
            p2.p((p2) q5.f1903c, i5);
            p5.c();
            j2.n((j2) p5.f1903c, (p2) q5.a());
            p5.c();
            j2.o((j2) p5.f1903c, i6);
            return (j2) p5.a();
        } catch (Exception e5) {
            com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to create logging payload", e5);
            return null;
        }
    }

    public static m2 b(int i5) {
        try {
            l2 n5 = m2.n();
            n5.c();
            m2.m((m2) n5.f1903c, i5);
            return (m2) n5.a();
        } catch (Exception e5) {
            com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to create logging payload", e5);
            return null;
        }
    }
}
