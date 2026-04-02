package com.pili.pldroid.player.report.core;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: QosRealtimeLogManager.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private Object f5061a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f5062b = new StringBuilder();

    /* compiled from: QosRealtimeLogManager.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f5063a = new c();
    }

    public static c a() {
        return a.f5063a;
    }

    public void b() {
        synchronized (this.f5061a) {
            this.f5062b.delete(0, this.f5062b.length());
        }
    }

    public String c() {
        String sb;
        if (this.f5062b == null || this.f5062b.length() == 0) {
            return null;
        }
        synchronized (this.f5061a) {
            sb = this.f5062b.toString();
        }
        return sb;
    }

    public boolean a(String str) {
        if (str == null || str.equals("") || this.f5062b.length() > 65536) {
            return false;
        }
        try {
            synchronized (this.f5061a) {
                this.f5062b.append(str);
            }
        } catch (OutOfMemoryError e) {
            ThrowableExtension.printStackTrace(e);
        }
        return true;
    }
}
