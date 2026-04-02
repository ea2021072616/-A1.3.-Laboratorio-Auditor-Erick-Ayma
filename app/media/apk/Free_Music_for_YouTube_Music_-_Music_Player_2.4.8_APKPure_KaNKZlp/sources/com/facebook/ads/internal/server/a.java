package com.facebook.ads.internal.server;

import android.content.Context;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.f.i;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.i.a.m;
import com.facebook.ads.internal.i.a.n;
import com.facebook.ads.internal.server.d;
import com.facebook.ads.internal.util.w;
import com.facebook.ads.internal.util.z;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
/* loaded from: classes.dex */
public class a {
    private static final z i = new z();
    private static final ThreadPoolExecutor j = (ThreadPoolExecutor) Executors.newCachedThreadPool(i);

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f1454a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1455b;
    private final h d;
    private InterfaceC0039a e;
    private com.facebook.ads.internal.f.f f;
    private com.facebook.ads.internal.i.a.a g;

    /* renamed from: c  reason: collision with root package name */
    private final c f1456c = c.a();
    private final String h = b.a();

    /* renamed from: com.facebook.ads.internal.server.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
        void a(com.facebook.ads.internal.b bVar);

        void a(e eVar);
    }

    public a(Context context) {
        this.f1455b = context.getApplicationContext();
        this.d = new h(this.f1455b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.ads.internal.b bVar) {
        if (this.e != null) {
            this.e.a(bVar);
        }
        a();
    }

    private void a(e eVar) {
        if (this.e != null) {
            this.e.a(eVar);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            d a2 = this.f1456c.a(str);
            com.facebook.ads.internal.f.d b2 = a2.b();
            if (b2 != null) {
                this.d.a(b2.b());
                com.facebook.ads.internal.util.d.a(b2.a().c(), this.f);
            }
            switch (a2.a()) {
                case ADS:
                    e eVar = (e) a2;
                    if (b2 != null && b2.a().d()) {
                        com.facebook.ads.internal.util.d.a(str, this.f);
                    }
                    a(eVar);
                    return;
                case ERROR:
                    f fVar = (f) a2;
                    String c2 = fVar.c();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(fVar.d(), AdErrorType.ERROR_MESSAGE);
                    if (c2 != null) {
                        str = c2;
                    }
                    a(adErrorTypeFromCode.getAdErrorWrapper(str));
                    return;
                default:
                    a(AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(str));
                    return;
            }
        } catch (Exception e) {
            a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.ads.internal.i.a.b b() {
        return new com.facebook.ads.internal.i.a.b() { // from class: com.facebook.ads.internal.server.a.2
            public void a(m mVar) {
                com.facebook.ads.internal.util.d.b(a.this.f);
                a.this.g = null;
                try {
                    n a2 = mVar.a();
                    if (a2 != null) {
                        String e = a2.e();
                        d a3 = a.this.f1456c.a(e);
                        if (a3.a() == d.a.ERROR) {
                            f fVar = (f) a3;
                            String c2 = fVar.c();
                            a.this.a(AdErrorType.adErrorTypeFromCode(fVar.d(), AdErrorType.ERROR_MESSAGE).getAdErrorWrapper(c2 == null ? e : c2));
                            return;
                        }
                    }
                } catch (JSONException e2) {
                }
                a.this.a(new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, mVar.getMessage()));
            }

            @Override // com.facebook.ads.internal.i.a.b
            public void a(n nVar) {
                if (nVar != null) {
                    String e = nVar.e();
                    com.facebook.ads.internal.util.d.b(a.this.f);
                    a.this.g = null;
                    a.this.a(e);
                }
            }

            @Override // com.facebook.ads.internal.i.a.b
            public void a(Exception exc) {
                if (m.class.equals(exc.getClass())) {
                    a((m) exc);
                } else {
                    a.this.a(new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, exc.getMessage()));
                }
            }
        };
    }

    public void a() {
        if (this.g != null) {
            this.g.c(1);
            this.g.b(1);
            this.g = null;
        }
    }

    public void a(final com.facebook.ads.internal.f.f fVar) {
        a();
        if (w.c(this.f1455b) == w.a.NONE) {
            a(new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f = fVar;
        com.facebook.ads.internal.util.a.a(this.f1455b);
        if (!com.facebook.ads.internal.util.d.a(fVar)) {
            j.submit(new Runnable() { // from class: com.facebook.ads.internal.server.a.1
                @Override // java.lang.Runnable
                public void run() {
                    i.b(a.this.f1455b);
                    a.this.f1454a = fVar.e();
                    try {
                        a.this.g = w.b(a.this.f1455b, fVar.e);
                        a.this.g.a(a.this.h, a.this.g.b().a((Map<? extends String, ? extends String>) a.this.f1454a), a.this.b());
                    } catch (Exception e) {
                        a.this.a(AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(e.getMessage()));
                    }
                }
            });
            return;
        }
        String c2 = com.facebook.ads.internal.util.d.c(fVar);
        if (c2 != null) {
            a(c2);
        } else {
            a(AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper(null));
        }
    }

    public void a(InterfaceC0039a interfaceC0039a) {
        this.e = interfaceC0039a;
    }
}
