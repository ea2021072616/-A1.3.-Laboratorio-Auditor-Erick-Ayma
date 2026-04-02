package com.pili.pldroid.player.qos;

import android.content.Context;
/* compiled from: PlayerEnv.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5034a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5035b = false;

    public static void a(Context context) {
        if (f5034a || !f5035b) {
            f5035b = true;
            com.pili.pldroid.player.report.b.a(context);
            c.a().a(context);
        }
    }

    public static void b(Context context) {
        if (f5034a || f5035b) {
            f5035b = false;
            c.a().a((Context) null);
        }
    }
}
