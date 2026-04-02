package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public final class jr extends BroadcastReceiver {

    /* renamed from: c  reason: collision with root package name */
    private static jr f1998c;

    /* renamed from: a  reason: collision with root package name */
    boolean f1999a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2000b;
    private boolean d;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f2001a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f2002b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f2003c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {f2001a, f2002b, f2003c, d};
    }

    private jr() {
        this.d = false;
        Context context = jy.a().f2022a;
        this.d = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        this.f2000b = a(context);
        if (this.d) {
            c();
        }
    }

    private boolean a(Context context) {
        if (!this.d || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = d().getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private synchronized void c() {
        if (!this.f1999a) {
            Context context = jy.a().f2022a;
            this.f2000b = a(context);
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f1999a = true;
        }
    }

    private static ConnectivityManager d() {
        return (ConnectivityManager) jy.a().f2022a.getSystemService("connectivity");
    }

    public static synchronized jr a() {
        jr jrVar;
        synchronized (jr.class) {
            if (f1998c == null) {
                f1998c = new jr();
            }
            jrVar = f1998c;
        }
        return jrVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean a2 = a(context);
        if (this.f2000b != a2) {
            this.f2000b = a2;
            jq jqVar = new jq();
            jqVar.f1996a = a2;
            jqVar.f1997b = b();
            ki.a().a(jqVar);
        }
    }

    public final int b() {
        if (!this.d) {
            return a.f2001a;
        }
        NetworkInfo activeNetworkInfo = d().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a.f2001a;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                return a.d;
            case 1:
                return a.f2003c;
            case 6:
            case 7:
            default:
                if (activeNetworkInfo.isConnected()) {
                    return a.f2002b;
                }
                return a.f2001a;
            case 8:
                return a.f2001a;
        }
    }
}
