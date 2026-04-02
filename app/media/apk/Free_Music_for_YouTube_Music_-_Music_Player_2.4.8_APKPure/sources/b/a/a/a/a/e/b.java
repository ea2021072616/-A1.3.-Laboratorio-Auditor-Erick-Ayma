package b.a.a.a.a.e;

import b.a.a.a.l;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: DefaultHttpRequestFactory.java */
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final l f184a;

    /* renamed from: b  reason: collision with root package name */
    private g f185b;

    /* renamed from: c  reason: collision with root package name */
    private SSLSocketFactory f186c;
    private boolean d;

    public b() {
        this(new b.a.a.a.b());
    }

    public b(l lVar) {
        this.f184a = lVar;
    }

    @Override // b.a.a.a.a.e.e
    public void a(g gVar) {
        if (this.f185b != gVar) {
            this.f185b = gVar;
            a();
        }
    }

    private synchronized void a() {
        this.d = false;
        this.f186c = null;
    }

    @Override // b.a.a.a.a.e.e
    public d a(c cVar, String str) {
        return a(cVar, str, Collections.emptyMap());
    }

    @Override // b.a.a.a.a.e.e
    public d a(c cVar, String str, Map<String, String> map) {
        d e;
        SSLSocketFactory b2;
        switch (cVar) {
            case GET:
                e = d.a((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case POST:
                e = d.b((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case PUT:
                e = d.d((CharSequence) str);
                break;
            case DELETE:
                e = d.e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.f185b != null && (b2 = b()) != null) {
            ((HttpsURLConnection) e.a()).setSSLSocketFactory(b2);
        }
        return e;
    }

    private boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory b() {
        if (this.f186c == null && !this.d) {
            this.f186c = c();
        }
        return this.f186c;
    }

    private synchronized SSLSocketFactory c() {
        SSLSocketFactory sSLSocketFactory;
        this.d = true;
        try {
            sSLSocketFactory = f.a(this.f185b);
            this.f184a.a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f184a.e("Fabric", "Exception while validating pinned certs", e);
            sSLSocketFactory = null;
        }
        return sSLSocketFactory;
    }
}
