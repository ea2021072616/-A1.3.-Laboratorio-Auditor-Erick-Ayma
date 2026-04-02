package d0;

import java.util.Locale;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Locale[] f2502a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean b(Locale locale, Locale locale2) {
        boolean z4;
        boolean z5;
        if (locale.equals(locale2)) {
            return true;
        }
        if (locale.getLanguage().equals(locale2.getLanguage())) {
            Locale[] localeArr = f2502a;
            int length = localeArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z4 = false;
                    break;
                } else if (localeArr[i5].equals(locale)) {
                    z4 = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (!z4) {
                int length2 = localeArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        z5 = false;
                        break;
                    } else if (localeArr[i6].equals(locale2)) {
                        z5 = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (!z5) {
                    String c5 = f0.c.c(f0.c.a(f0.c.b(locale)));
                    if (c5.isEmpty()) {
                        String country = locale.getCountry();
                        return country.isEmpty() || country.equals(locale2.getCountry());
                    }
                    return c5.equals(f0.c.c(f0.c.a(f0.c.b(locale2))));
                }
            }
            return false;
        }
        return false;
    }
}
