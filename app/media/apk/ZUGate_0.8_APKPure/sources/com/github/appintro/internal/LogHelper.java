package com.github.appintro.internal;

import android.util.Log;
import e4.e;
import j4.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import n4.b;
import p4.d;
/* loaded from: classes.dex */
public final class LogHelper {
    public static final LogHelper INSTANCE = new LogHelper();

    private LogHelper() {
    }

    private final String cutTagLength(String str, int i5) {
        if (str.length() > i5) {
            String substring = str.substring(0, i5 - 1);
            e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static final int d(String str, String str2) {
        e.f(str, "tag");
        e.f(str2, "message");
        return Log.d(str, str2);
    }

    public static final void e(String str, String str2) {
        e$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            th = null;
        }
        e(str, str2, th);
    }

    public static final int i(String str, String str2) {
        e.f(str, "tag");
        e.f(str2, "message");
        return Log.i(str, str2);
    }

    public static final String makeLogTag(Class<?> cls) {
        e.f(cls, "cls");
        return "Log: " + INSTANCE.cutTagLength(cls.getSimpleName(), 18);
    }

    public static final int v(String str, String str2) {
        e.f(str, "tag");
        e.f(str2, "message");
        return Log.v(str, str2);
    }

    public static final void w(String str, String str2) {
        w$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            th = null;
        }
        w(str, str2, th);
    }

    public static final void wtf(String str, String str2) {
        wtf$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }

    public static final void e(String str, String str2, Throwable th) {
        e.f(str, "tag");
        e.f(str2, "message");
        Log.e(str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        e.f(str, "tag");
        e.f(str2, "message");
        Log.w(str, str2, th);
    }

    public static final void wtf(String str, String str2, Throwable th) {
        e.f(str, "tag");
        e.f(str2, "message");
        Log.wtf(str, str2, th);
    }

    public final String makeLogTag(b bVar) {
        String str;
        e.f(bVar, "cls");
        StringBuilder sb = new StringBuilder("Log: ");
        Class cls = ((c) bVar).f3518a;
        e.f(cls, "jClass");
        String str2 = null;
        if (!cls.isAnonymousClass()) {
            if (cls.isLocalClass()) {
                str2 = cls.getSimpleName();
                Method enclosingMethod = cls.getEnclosingMethod();
                if (enclosingMethod != null) {
                    str2 = d.J0(str2, enclosingMethod.getName() + '$');
                } else {
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        str2 = d.J0(str2, enclosingConstructor.getName() + '$');
                    } else {
                        int indexOf = str2.indexOf(36, 0);
                        if (indexOf != -1) {
                            str2 = str2.substring(indexOf + 1, str2.length());
                            e.e(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                    }
                }
            } else {
                boolean isArray = cls.isArray();
                LinkedHashMap linkedHashMap = c.f3517c;
                if (isArray) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                        str2 = str.concat("Array");
                    }
                    if (str2 == null) {
                        str2 = "Array";
                    }
                } else {
                    str2 = (String) linkedHashMap.get(cls.getName());
                    if (str2 == null) {
                        str2 = cls.getSimpleName();
                    }
                }
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        sb.append(cutTagLength(str2, 18));
        return sb.toString();
    }
}
