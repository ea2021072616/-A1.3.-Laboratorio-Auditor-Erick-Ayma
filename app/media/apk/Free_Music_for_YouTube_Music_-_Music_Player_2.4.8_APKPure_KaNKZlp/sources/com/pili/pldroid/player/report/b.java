package com.pili.pldroid.player.report;

import android.content.Context;
import com.pili.pldroid.player.report.core.d;
/* compiled from: QosEnv.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5047a = false;

    public static void a(Context context) {
        if (!f5047a && context != null) {
            f5047a = true;
            a.a().a(context.getApplicationContext());
            a.a().a(true);
            d.a().a(context.getApplicationContext());
        }
    }

    public static void a() {
        d.a().b((Context) null);
        a.a().b();
        com.pili.pldroid.player.report.common.a.h();
        f5047a = false;
    }
}
