package com.flurry.sdk;
/* loaded from: classes.dex */
public final class lu {

    /* renamed from: a  reason: collision with root package name */
    long f2180a = 1000;

    /* renamed from: b  reason: collision with root package name */
    boolean f2181b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f2182c = false;
    ma d = new ma() { // from class: com.flurry.sdk.lu.1
        @Override // com.flurry.sdk.ma
        public final void a() {
            ki.a().a(new ls());
            if (lu.this.f2181b && lu.this.f2182c) {
                jy.a().a(lu.this.d, lu.this.f2180a);
            }
        }
    };

    public final synchronized void a() {
        if (!this.f2182c) {
            jy.a().a(this.d, this.f2180a);
            this.f2182c = true;
        }
    }

    public final synchronized void b() {
        if (this.f2182c) {
            jy a2 = jy.a();
            ma maVar = this.d;
            if (maVar != null) {
                a2.f2024c.removeCallbacks(maVar);
            }
            this.f2182c = false;
        }
    }
}
