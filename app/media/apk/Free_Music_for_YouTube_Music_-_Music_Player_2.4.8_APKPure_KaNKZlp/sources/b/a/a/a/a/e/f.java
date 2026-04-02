package b.a.a.a.a.e;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
/* compiled from: NetworkUtils.java */
/* loaded from: classes.dex */
public final class f {
    public static final SSLSocketFactory a(g gVar) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new h(new i(gVar.getKeyStoreStream(), gVar.getKeyStorePassword()), gVar)}, null);
        return sSLContext.getSocketFactory();
    }
}
