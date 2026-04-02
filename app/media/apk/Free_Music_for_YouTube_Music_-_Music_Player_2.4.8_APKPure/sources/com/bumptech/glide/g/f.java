package com.bumptech.glide.g;
/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class f implements b, c {

    /* renamed from: a  reason: collision with root package name */
    private b f710a;

    /* renamed from: b  reason: collision with root package name */
    private b f711b;

    /* renamed from: c  reason: collision with root package name */
    private c f712c;

    public f() {
        this(null);
    }

    public f(c cVar) {
        this.f712c = cVar;
    }

    public void a(b bVar, b bVar2) {
        this.f710a = bVar;
        this.f711b = bVar2;
    }

    @Override // com.bumptech.glide.g.c
    public boolean a(b bVar) {
        return j() && (bVar.equals(this.f710a) || !this.f710a.h());
    }

    private boolean j() {
        return this.f712c == null || this.f712c.a(this);
    }

    @Override // com.bumptech.glide.g.c
    public boolean b(b bVar) {
        return k() && bVar.equals(this.f710a) && !c();
    }

    private boolean k() {
        return this.f712c == null || this.f712c.b(this);
    }

    @Override // com.bumptech.glide.g.c
    public boolean c() {
        return l() || h();
    }

    @Override // com.bumptech.glide.g.c
    public void c(b bVar) {
        if (!bVar.equals(this.f711b)) {
            if (this.f712c != null) {
                this.f712c.c(this);
            }
            if (!this.f711b.g()) {
                this.f711b.d();
            }
        }
    }

    private boolean l() {
        return this.f712c != null && this.f712c.c();
    }

    @Override // com.bumptech.glide.g.b
    public void b() {
        if (!this.f711b.f()) {
            this.f711b.b();
        }
        if (!this.f710a.f()) {
            this.f710a.b();
        }
    }

    @Override // com.bumptech.glide.g.b
    public void e() {
        this.f710a.e();
        this.f711b.e();
    }

    @Override // com.bumptech.glide.g.b
    public void d() {
        this.f711b.d();
        this.f710a.d();
    }

    @Override // com.bumptech.glide.g.b
    public boolean f() {
        return this.f710a.f();
    }

    @Override // com.bumptech.glide.g.b
    public boolean g() {
        return this.f710a.g() || this.f711b.g();
    }

    @Override // com.bumptech.glide.g.b
    public boolean h() {
        return this.f710a.h() || this.f711b.h();
    }

    @Override // com.bumptech.glide.g.b
    public boolean i() {
        return this.f710a.i();
    }

    @Override // com.bumptech.glide.g.b
    public void a() {
        this.f710a.a();
        this.f711b.a();
    }
}
