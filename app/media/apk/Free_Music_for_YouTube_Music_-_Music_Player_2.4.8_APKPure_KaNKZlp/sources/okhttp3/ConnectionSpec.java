package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public final class ConnectionSpec {
    final String[] cipherSuites;
    final boolean supportsTlsExtensions;
    final boolean tls;
    final String[] tlsVersions;
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();

    ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.tls;
    }

    public List<CipherSuite> cipherSuites() {
        if (this.cipherSuites == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.cipherSuites.length);
        for (String str : this.cipherSuites) {
            arrayList.add(CipherSuite.forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<TlsVersion> tlsVersions() {
        if (this.tlsVersions == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.tlsVersions.length);
        for (String str : this.tlsVersions) {
            arrayList.add(TlsVersion.forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void apply(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec supportedSpec = supportedSpec(sSLSocket, z);
        if (supportedSpec.tlsVersions != null) {
            sSLSocket.setEnabledProtocols(supportedSpec.tlsVersions);
        }
        if (supportedSpec.cipherSuites != null) {
            sSLSocket.setEnabledCipherSuites(supportedSpec.cipherSuites);
        }
    }

    private ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.cipherSuites != null) {
            enabledCipherSuites = (String[]) Util.intersect(String.class, this.cipherSuites, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersions != null) {
            enabledProtocols = (String[]) Util.intersect(String.class, this.tlsVersions, sSLSocket.getEnabledProtocols());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        if (z && Util.indexOf(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            enabledCipherSuites = Util.concat(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        return new Builder(this).cipherSuites(enabledCipherSuites).tlsVersions(enabledProtocols).build();
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (this.tls) {
            if (this.tlsVersions == null || nonEmptyIntersection(this.tlsVersions, sSLSocket.getEnabledProtocols())) {
                return this.cipherSuites == null || nonEmptyIntersection(this.cipherSuites, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    private static boolean nonEmptyIntersection(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (Util.indexOf(strArr2, str) != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ConnectionSpec) {
            if (obj == this) {
                return true;
            }
            ConnectionSpec connectionSpec = (ConnectionSpec) obj;
            if (this.tls == connectionSpec.tls) {
                return !this.tls || (Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        if (!this.tls) {
            return 17;
        }
        return (this.supportsTlsExtensions ? 0 : 1) + ((((Arrays.hashCode(this.cipherSuites) + 527) * 31) + Arrays.hashCode(this.tlsVersions)) * 31);
    }

    public String toString() {
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.cipherSuites != null ? cipherSuites().toString() : "[all enabled]") + ", tlsVersions=" + (this.tlsVersions != null ? tlsVersions().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;
        String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.tls) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                return cipherSuites(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(String... strArr) {
            if (this.tls) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                this.cipherSuites = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.tls) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return tlsVersions(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(String... strArr) {
            if (this.tls) {
                if (strArr.length == 0) {
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                this.tlsVersions = (String[]) strArr.clone();
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }
}
