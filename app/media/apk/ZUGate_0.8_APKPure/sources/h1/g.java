package h1;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3282a;

    /* renamed from: b  reason: collision with root package name */
    public int f3283b;

    /* renamed from: c  reason: collision with root package name */
    public String f3284c;

    public g() {
        this.f3282a = 1;
    }

    public static g b() {
        return new g(0);
    }

    public final g a() {
        g gVar = new g();
        gVar.f3283b = this.f3283b;
        gVar.f3284c = this.f3284c;
        return gVar;
    }

    public final String toString() {
        switch (this.f3282a) {
            case 1:
                int i5 = this.f3283b;
                int i6 = com.google.android.gms.internal.play_billing.s.f1952a;
                com.google.android.gms.internal.play_billing.o oVar = com.google.android.gms.internal.play_billing.a.f1830d;
                Integer valueOf = Integer.valueOf(i5);
                String obj = (!oVar.containsKey(valueOf) ? com.google.android.gms.internal.play_billing.a.f1829c : (com.google.android.gms.internal.play_billing.a) oVar.get(valueOf)).toString();
                String str = this.f3284c;
                return "Response Code: " + obj + ", Debug Message: " + str;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ g(int i5) {
        this.f3282a = 0;
        this.f3284c = "";
    }
}
