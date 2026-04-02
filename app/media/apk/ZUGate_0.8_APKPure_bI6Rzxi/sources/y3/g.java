package y3;
/* loaded from: classes.dex */
public final class g implements v3.g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5705a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5706b = false;

    /* renamed from: c  reason: collision with root package name */
    public v3.c f5707c;

    /* renamed from: d  reason: collision with root package name */
    public final f f5708d;

    public g(f fVar) {
        this.f5708d = fVar;
    }

    @Override // v3.g
    public final v3.g a(String str) {
        if (this.f5705a) {
            throw new v3.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f5705a = true;
        this.f5708d.a(this.f5707c, str, this.f5706b);
        return this;
    }

    @Override // v3.g
    public final v3.g b(boolean z4) {
        if (this.f5705a) {
            throw new v3.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f5705a = true;
        this.f5708d.b(this.f5707c, z4 ? 1 : 0, this.f5706b);
        return this;
    }
}
