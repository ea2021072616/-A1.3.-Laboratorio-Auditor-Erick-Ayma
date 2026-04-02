package com.flurry.sdk;

import android.support.v7.widget.ActivityChooserView;
import com.flurry.sdk.kw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class kx<ReportInfo extends kw> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2094a = kx.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static long f2095b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2096c;
    public long d;
    private final kf<List<ReportInfo>> f;
    private int h;
    private final int e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final List<ReportInfo> g = new ArrayList();
    private final Runnable i = new ma() { // from class: com.flurry.sdk.kx.1
        @Override // com.flurry.sdk.ma
        public final void a() {
            kx.this.b();
        }
    };
    private final kh<jq> j = new kh<jq>() { // from class: com.flurry.sdk.kx.2
        @Override // com.flurry.sdk.kh
        public final /* bridge */ /* synthetic */ void a(jq jqVar) {
            if (jqVar.f1996a) {
                kx.this.b();
            }
        }
    };

    public abstract kf<List<ReportInfo>> a();

    public abstract void a(ReportInfo reportinfo);

    public kx() {
        ki.a().a("com.flurry.android.sdk.NetworkStateEvent", this.j);
        this.f = a();
        this.d = f2095b;
        this.h = -1;
        jy.a().b(new ma() { // from class: com.flurry.sdk.kx.3
            @Override // com.flurry.sdk.ma
            public final void a() {
                kx.this.a(kx.this.g);
                kx.this.b();
            }
        });
    }

    public synchronized void a(List<ReportInfo> list) {
        ly.b();
        List<ReportInfo> a2 = this.f.a();
        if (a2 != null) {
            list.addAll(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (!this.f2096c) {
            if (this.h >= 0) {
                km.a(3, f2094a, "Transmit is in progress");
            } else {
                d();
                if (this.g.isEmpty()) {
                    this.d = f2095b;
                    this.h = -1;
                } else {
                    this.h = 0;
                    jy.a().b(new ma() { // from class: com.flurry.sdk.kx.4
                        @Override // com.flurry.sdk.ma
                        public final void a() {
                            kx.this.e();
                        }
                    });
                }
            }
        }
    }

    private synchronized void d() {
        Iterator<ReportInfo> it = this.g.iterator();
        while (it.hasNext()) {
            ReportInfo next = it.next();
            if (next.o) {
                km.a(3, f2094a, "Url transmitted - " + next.q + " Attempts: " + next.p);
                it.remove();
            } else if (next.p > next.a()) {
                km.a(3, f2094a, "Exceeded max no of attempts - " + next.q + " Attempts: " + next.p);
                it.remove();
            } else if (System.currentTimeMillis() > next.n && next.p > 0) {
                km.a(3, f2094a, "Expired: Time expired - " + next.q + " Attempts: " + next.p);
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        ReportInfo reportinfo;
        ly.b();
        if (jr.a().f2000b) {
            while (this.h < this.g.size()) {
                List<ReportInfo> list = this.g;
                int i = this.h;
                this.h = i + 1;
                reportinfo = list.get(i);
                if (!reportinfo.o) {
                    break;
                }
            }
        } else {
            km.a(3, f2094a, "Network is not available, aborting transmission");
        }
        reportinfo = null;
        if (reportinfo == null) {
            f();
        } else {
            a((kx<ReportInfo>) reportinfo);
        }
    }

    private synchronized void f() {
        d();
        b(this.g);
        if (this.f2096c) {
            km.a(3, f2094a, "Reporter paused");
            this.d = f2095b;
        } else if (this.g.isEmpty()) {
            km.a(3, f2094a, "All reports sent successfully");
            this.d = f2095b;
        } else {
            this.d <<= 1;
            km.a(3, f2094a, "One or more reports failed to send, backing off: " + this.d + "ms");
            jy.a().a(this.i, this.d);
        }
        this.h = -1;
    }

    public synchronized void b(List<ReportInfo> list) {
        ly.b();
        this.f.a(new ArrayList(list));
    }

    public final void c() {
        this.f2096c = false;
        jy.a().b(new ma() { // from class: com.flurry.sdk.kx.5
            @Override // com.flurry.sdk.ma
            public final void a() {
                kx.this.b();
            }
        });
    }

    public final synchronized void b(ReportInfo reportinfo) {
        if (reportinfo != null) {
            this.g.add(reportinfo);
            jy.a().b(new ma() { // from class: com.flurry.sdk.kx.6
                @Override // com.flurry.sdk.ma
                public final void a() {
                    kx.this.b();
                }
            });
        }
    }

    public final synchronized void c(ReportInfo reportinfo) {
        reportinfo.o = true;
        jy.a().b(new ma() { // from class: com.flurry.sdk.kx.7
            @Override // com.flurry.sdk.ma
            public final void a() {
                kx.this.e();
            }
        });
    }

    public final synchronized void d(ReportInfo reportinfo) {
        reportinfo.a_();
        jy.a().b(new ma() { // from class: com.flurry.sdk.kx.8
            @Override // com.flurry.sdk.ma
            public final void a() {
                kx.this.e();
            }
        });
    }
}
