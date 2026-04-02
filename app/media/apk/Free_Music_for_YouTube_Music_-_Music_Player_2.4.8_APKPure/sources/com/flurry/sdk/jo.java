package com.flurry.sdk;

import b.a.a.a.a.d.b;
import java.util.Locale;
/* loaded from: classes.dex */
public final class jo {

    /* renamed from: a  reason: collision with root package name */
    private static jo f1990a;

    private jo() {
    }

    public static synchronized jo a() {
        jo joVar;
        synchronized (jo.class) {
            if (f1990a == null) {
                f1990a = new jo();
            }
            joVar = f1990a;
        }
        return joVar;
    }

    public static String b() {
        return Locale.getDefault().getLanguage() + b.ROLL_OVER_FILE_NAME_SEPARATOR + Locale.getDefault().getCountry();
    }
}
