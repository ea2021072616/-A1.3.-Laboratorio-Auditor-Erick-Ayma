package d0;

import android.content.res.Configuration;
import android.os.LocaleList;
/* loaded from: classes.dex */
public abstract class d {
    public static LocaleList a(Configuration configuration) {
        return configuration.getLocales();
    }

    public static void b(Configuration configuration, g gVar) {
        configuration.setLocales((LocaleList) gVar.f2504a.a());
    }
}
