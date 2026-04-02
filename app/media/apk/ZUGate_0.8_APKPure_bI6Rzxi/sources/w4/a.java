package w4;
/* loaded from: classes.dex */
public final /* synthetic */ class a implements x4.g {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5411g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ru.zdevs.zugate.jni.b f5412h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f5413i;

    public /* synthetic */ a(ru.zdevs.zugate.jni.b bVar, String str, int i5) {
        this.f5411g = i5;
        this.f5412h = bVar;
        this.f5413i = str;
    }

    @Override // x4.g
    public final void d(String str) {
        int i5 = this.f5411g;
        String str2 = this.f5413i;
        ru.zdevs.zugate.jni.b bVar = this.f5412h;
        switch (i5) {
            case 0:
                String[] b02 = b4.j.b0(str, " ");
                if (b02.length <= 2 || !b02[1].startsWith(c.f5419e)) {
                    return;
                }
                bVar.f4624g = str2;
                bVar.f4625h = b02[1];
                return;
            default:
                bVar.f4624g = str2;
                return;
        }
    }
}
