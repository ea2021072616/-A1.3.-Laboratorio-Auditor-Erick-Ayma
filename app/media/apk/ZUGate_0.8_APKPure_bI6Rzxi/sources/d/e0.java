package d;

import android.content.res.Configuration;
import android.os.LocaleList;
/* loaded from: classes.dex */
public abstract class e0 {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static d0.g b(Configuration configuration) {
        return d0.g.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(d0.g gVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(((d0.i) gVar.f2504a).f2505a.toLanguageTags()));
    }

    public static void d(Configuration configuration, d0.g gVar) {
        configuration.setLocales(LocaleList.forLanguageTags(((d0.i) gVar.f2504a).f2505a.toLanguageTags()));
    }
}
