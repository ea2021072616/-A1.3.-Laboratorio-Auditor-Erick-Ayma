package okhttp3;

import c.f;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, Charset.forName("ISO-8859-1"));
    }

    public static String basic(String str, String str2, Charset charset) {
        return "Basic " + f.a((str + ":" + str2).getBytes(charset)).b();
    }
}
