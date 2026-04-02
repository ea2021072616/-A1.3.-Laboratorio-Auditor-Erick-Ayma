package com.fotoable.youtube.music.util;

import android.content.Context;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.core.CrashlyticsCore;
import com.flurry.android.FlurryAgent;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashMap;
/* compiled from: AnalysisUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4861a = false;

    public static void a(String str, String str2, Object obj) {
        if (com.fotoable.youtube.music.a.c()) {
            b("印度-" + str, str2, obj);
        } else if (com.fotoable.youtube.music.a.d()) {
            b("日本-" + str, str2, obj);
        } else if (com.fotoable.youtube.music.a.e()) {
            b("巴西-" + str, str2, obj);
        } else if (com.fotoable.youtube.music.a.g()) {
            b("美区-" + str, str2, obj);
        } else if (com.fotoable.youtube.music.a.f()) {
            b("墨西哥-" + str, str2, obj);
        }
    }

    public static void a(String str) {
        if (com.fotoable.youtube.music.a.c()) {
            b("印度-" + str);
        } else if (com.fotoable.youtube.music.a.d()) {
            b("日本-" + str);
        } else if (com.fotoable.youtube.music.a.e()) {
            b("巴西-" + str);
        } else if (com.fotoable.youtube.music.a.g()) {
            b("美区-" + str);
        } else if (com.fotoable.youtube.music.a.f()) {
            b("墨西哥-" + str);
        }
    }

    public static void b(String str, String str2, Object obj) {
        if (!f4861a) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(str2, String.valueOf(obj));
                FlurryAgent.logEvent(str, hashMap);
                CustomEvent customEvent = new CustomEvent("" + str);
                if (str2 != null && obj != null) {
                    customEvent.putCustomAttribute(str2, obj.toString());
                }
                Answers.getInstance().logCustom(customEvent);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public static void b(String str) {
        if (!f4861a) {
            try {
                FlurryAgent.logEvent(str);
                Answers.getInstance().logCustom(new CustomEvent("" + str));
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public static void a(Throwable th) {
        if (th != null) {
            try {
                CrashlyticsCore.getInstance().logException(th);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public static void a(Context context) {
        if (!f4861a) {
            try {
                FlurryAgent.onStartSession(context);
            } catch (Exception e) {
            }
        }
    }

    public static void b(Context context) {
        if (!f4861a) {
            try {
                FlurryAgent.onEndSession(context);
            } catch (Exception e) {
            }
        }
    }
}
