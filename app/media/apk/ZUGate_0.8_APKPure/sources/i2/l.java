package i2;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import l2.j0;
import l2.t;
/* loaded from: classes.dex */
public abstract class l extends j0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3404a;

    public l(byte[] bArr) {
        if (!(bArr.length == 25)) {
            throw new IllegalArgumentException();
        }
        this.f3404a = Arrays.hashCode(bArr);
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    public abstract byte[] c();

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof t)) {
            try {
                t tVar = (t) obj;
                if (((l) tVar).f3404a != this.f3404a) {
                    return false;
                }
                return Arrays.equals(c(), (byte[]) new q2.a(((l) tVar).c()).f4454a);
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3404a;
    }
}
