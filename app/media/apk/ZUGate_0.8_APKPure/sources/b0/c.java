package b0;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Signature f1606a;

    /* renamed from: b  reason: collision with root package name */
    public final Cipher f1607b;

    /* renamed from: c  reason: collision with root package name */
    public final Mac f1608c;

    public c(Signature signature) {
        this.f1606a = signature;
        this.f1607b = null;
        this.f1608c = null;
    }

    public c(Cipher cipher) {
        this.f1607b = cipher;
        this.f1606a = null;
        this.f1608c = null;
    }

    public c(Mac mac) {
        this.f1608c = mac;
        this.f1607b = null;
        this.f1606a = null;
    }
}
