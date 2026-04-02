package com.facebook.ads.internal.util;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
/* loaded from: classes.dex */
public class ab extends ah {

    /* renamed from: a  reason: collision with root package name */
    public int f1475a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.view.d.a.u f1476b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.q> f1477c;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.h> d;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.j> e;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.n> f;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b> g;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.p> h;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.v> i;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.w> j;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.r> k;
    private final com.facebook.ads.internal.view.d.a.m l;
    private final com.facebook.ads.internal.view.n m;
    private boolean n;

    public ab(Context context, com.facebook.ads.internal.g.f fVar, com.facebook.ads.internal.view.n nVar, String str) {
        super(context, fVar, nVar, str);
        this.f1476b = new com.facebook.ads.internal.view.d.a.u() { // from class: com.facebook.ads.internal.util.ab.1

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1478a;

            static {
                f1478a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.t tVar) {
                if (!f1478a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                ab.this.e();
            }
        };
        this.f1477c = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.q>() { // from class: com.facebook.ads.internal.util.ab.4

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1484a;

            static {
                f1484a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.q> a() {
                return com.facebook.ads.internal.view.d.a.q.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.q qVar) {
                if (!f1484a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                ab.this.h();
            }
        };
        this.d = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.h>() { // from class: com.facebook.ads.internal.util.ab.5

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1486a;

            static {
                f1486a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.h> a() {
                return com.facebook.ads.internal.view.d.a.h.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.h hVar) {
                if (!f1486a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                ab.this.i();
            }
        };
        this.e = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.j>() { // from class: com.facebook.ads.internal.util.ab.6

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1488a;

            static {
                f1488a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.j> a() {
                return com.facebook.ads.internal.view.d.a.j.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.j jVar) {
                if (!f1488a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                if (ab.this.n) {
                    ab.this.j();
                } else {
                    ab.this.n = true;
                }
            }
        };
        this.f = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.n>() { // from class: com.facebook.ads.internal.util.ab.7
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.n> a() {
                return com.facebook.ads.internal.view.d.a.n.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.n nVar2) {
                if (ab.this.f1475a <= 0 || ab.this.m.getCurrentPosition() != ab.this.m.getDuration() || ab.this.m.getDuration() <= ab.this.f1475a) {
                    ab.this.a(ab.this.m.getCurrentPosition());
                }
            }
        };
        this.g = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b>() { // from class: com.facebook.ads.internal.util.ab.8
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.b> a() {
                return com.facebook.ads.internal.view.d.a.b.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                int currentPosition = ab.this.m.getCurrentPosition();
                if (ab.this.f1475a <= 0 || currentPosition != ab.this.m.getDuration() || ab.this.m.getDuration() <= ab.this.f1475a) {
                    if (!(currentPosition == 0 && ab.this.m.b()) && ab.this.m.getDuration() >= currentPosition + 500) {
                        ab.this.b(currentPosition);
                    } else {
                        ab.this.b(ab.this.m.getDuration());
                    }
                }
            }
        };
        this.h = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.p>() { // from class: com.facebook.ads.internal.util.ab.9
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.p> a() {
                return com.facebook.ads.internal.view.d.a.p.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.p pVar) {
                ab.this.a(pVar.a(), pVar.b());
            }
        };
        this.i = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.v>() { // from class: com.facebook.ads.internal.util.ab.10
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.v> a() {
                return com.facebook.ads.internal.view.d.a.v.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.v vVar) {
                ab.this.b();
            }
        };
        this.j = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.w>() { // from class: com.facebook.ads.internal.util.ab.11
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.w> a() {
                return com.facebook.ads.internal.view.d.a.w.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.w wVar) {
                ab.this.c();
            }
        };
        this.k = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.r>() { // from class: com.facebook.ads.internal.util.ab.2
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.r> a() {
                return com.facebook.ads.internal.view.d.a.r.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.r rVar) {
                ab.this.a(ab.this.k(), ab.this.k());
            }
        };
        this.l = new com.facebook.ads.internal.view.d.a.m() { // from class: com.facebook.ads.internal.util.ab.3
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.l lVar) {
                ab.this.f1475a = ab.this.m.getDuration();
            }
        };
        this.n = false;
        this.m = nVar;
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1476b);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1477c);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.e);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.d);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.g);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.h);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.i);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.j);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.l);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.k);
    }

    public ab(Context context, com.facebook.ads.internal.g.f fVar, com.facebook.ads.internal.view.n nVar, String str, @Nullable Bundle bundle) {
        super(context, fVar, nVar, str, bundle);
        this.f1476b = new com.facebook.ads.internal.view.d.a.u() { // from class: com.facebook.ads.internal.util.ab.1

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1478a;

            static {
                f1478a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.t tVar) {
                if (!f1478a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                ab.this.e();
            }
        };
        this.f1477c = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.q>() { // from class: com.facebook.ads.internal.util.ab.4

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1484a;

            static {
                f1484a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.q> a() {
                return com.facebook.ads.internal.view.d.a.q.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.q qVar) {
                if (!f1484a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                ab.this.h();
            }
        };
        this.d = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.h>() { // from class: com.facebook.ads.internal.util.ab.5

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1486a;

            static {
                f1486a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.h> a() {
                return com.facebook.ads.internal.view.d.a.h.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.h hVar) {
                if (!f1486a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                ab.this.i();
            }
        };
        this.e = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.j>() { // from class: com.facebook.ads.internal.util.ab.6

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f1488a;

            static {
                f1488a = !ab.class.desiredAssertionStatus();
            }

            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.j> a() {
                return com.facebook.ads.internal.view.d.a.j.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.j jVar) {
                if (!f1488a && ab.this == null) {
                    throw new AssertionError();
                }
                if (ab.this == null) {
                    return;
                }
                if (ab.this.n) {
                    ab.this.j();
                } else {
                    ab.this.n = true;
                }
            }
        };
        this.f = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.n>() { // from class: com.facebook.ads.internal.util.ab.7
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.n> a() {
                return com.facebook.ads.internal.view.d.a.n.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.n nVar2) {
                if (ab.this.f1475a <= 0 || ab.this.m.getCurrentPosition() != ab.this.m.getDuration() || ab.this.m.getDuration() <= ab.this.f1475a) {
                    ab.this.a(ab.this.m.getCurrentPosition());
                }
            }
        };
        this.g = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b>() { // from class: com.facebook.ads.internal.util.ab.8
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.b> a() {
                return com.facebook.ads.internal.view.d.a.b.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                int currentPosition = ab.this.m.getCurrentPosition();
                if (ab.this.f1475a <= 0 || currentPosition != ab.this.m.getDuration() || ab.this.m.getDuration() <= ab.this.f1475a) {
                    if (!(currentPosition == 0 && ab.this.m.b()) && ab.this.m.getDuration() >= currentPosition + 500) {
                        ab.this.b(currentPosition);
                    } else {
                        ab.this.b(ab.this.m.getDuration());
                    }
                }
            }
        };
        this.h = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.p>() { // from class: com.facebook.ads.internal.util.ab.9
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.p> a() {
                return com.facebook.ads.internal.view.d.a.p.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.p pVar) {
                ab.this.a(pVar.a(), pVar.b());
            }
        };
        this.i = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.v>() { // from class: com.facebook.ads.internal.util.ab.10
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.v> a() {
                return com.facebook.ads.internal.view.d.a.v.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.v vVar) {
                ab.this.b();
            }
        };
        this.j = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.w>() { // from class: com.facebook.ads.internal.util.ab.11
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.w> a() {
                return com.facebook.ads.internal.view.d.a.w.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.w wVar) {
                ab.this.c();
            }
        };
        this.k = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.r>() { // from class: com.facebook.ads.internal.util.ab.2
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.r> a() {
                return com.facebook.ads.internal.view.d.a.r.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.r rVar) {
                ab.this.a(ab.this.k(), ab.this.k());
            }
        };
        this.l = new com.facebook.ads.internal.view.d.a.m() { // from class: com.facebook.ads.internal.util.ab.3
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.l lVar) {
                ab.this.f1475a = ab.this.m.getDuration();
            }
        };
        this.n = false;
        this.m = nVar;
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1476b);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1477c);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.e);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.d);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.g);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.i);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.j);
        nVar.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.k);
    }

    public void a() {
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1476b);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1477c);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.e);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.d);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.g);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.i);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.j);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.l);
        this.m.getEventBus().b((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.k);
    }
}
