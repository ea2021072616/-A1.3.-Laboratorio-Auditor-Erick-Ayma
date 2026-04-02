package v1;

import com.google.android.gms.internal.play_billing.i0;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import x1.k;
/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: c  reason: collision with root package name */
    public static final String f5186c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set f5187d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f5188e;

    /* renamed from: a  reason: collision with root package name */
    public final String f5189a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5190b;

    static {
        String H = i0.H("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f5186c = H;
        i0.H("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        i0.H("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f5187d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new u1.b("proto"), new u1.b("json"))));
        f5188e = new a(H, null);
    }

    public a(String str, String str2) {
        this.f5189a = str;
        this.f5190b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (str2.isEmpty()) {
                    throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
                }
                String str3 = split[1];
                if (str3.isEmpty()) {
                    str3 = null;
                }
                return new a(str2, str3);
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }
}
