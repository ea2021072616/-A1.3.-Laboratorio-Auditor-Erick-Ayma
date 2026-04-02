package com.pili.pldroid.player.qos;

import android.content.Context;
import android.content.Intent;
import com.pili.pldroid.player.report.core.e;
/* compiled from: QosSender.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f5036a;

    /* compiled from: QosSender.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f5037a = new c();
    }

    private c() {
    }

    public static c a() {
        return a.f5037a;
    }

    public void a(Context context) {
        if (context != null) {
            this.f5036a = context.getApplicationContext();
        } else {
            this.f5036a = null;
        }
    }

    public int b() {
        return e.a();
    }

    public void a(Intent intent) {
        if (this.f5036a != null) {
            com.pili.pldroid.player.report.a.a().a(intent);
        }
    }
}
