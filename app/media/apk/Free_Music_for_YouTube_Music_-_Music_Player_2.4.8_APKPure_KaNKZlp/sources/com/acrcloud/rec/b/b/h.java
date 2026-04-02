package com.acrcloud.rec.b.b;

import android.util.Log;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: ACRCloudLogger.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f353a = false;

    public static void a(String str, String str2) {
        if (f353a) {
            try {
                Log.e(str, str2);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public static void b(String str, String str2) {
        if (f353a) {
            try {
                Log.d(str, str2);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }
}
