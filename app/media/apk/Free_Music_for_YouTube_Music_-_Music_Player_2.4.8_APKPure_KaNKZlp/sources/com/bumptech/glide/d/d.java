package com.bumptech.glide.d;

import android.content.Context;
import com.bumptech.glide.d.c;
/* compiled from: ConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class d {
    public c a(Context context, c.a aVar) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            return new e(context, aVar);
        }
        return new i();
    }
}
