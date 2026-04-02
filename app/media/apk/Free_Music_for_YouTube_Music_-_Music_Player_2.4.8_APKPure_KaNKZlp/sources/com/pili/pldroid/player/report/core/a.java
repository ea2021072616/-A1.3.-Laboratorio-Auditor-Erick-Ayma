package com.pili.pldroid.player.report.core;

import android.annotation.TargetApi;
import android.view.Choreographer;
import java.util.concurrent.TimeUnit;
/* compiled from: FPSFrameCallback.java */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class a implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5055a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final long f5056b = TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: c  reason: collision with root package name */
    private static final long f5057c = TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS);
    private static long d = 0;
    private static long e = 0;
    private static int f = 0;
    private static int g = 0;
    private static boolean h = false;

    public void a() {
        if (h) {
            h = false;
            g = 0;
            f = 0;
            e = 0L;
            d = 0L;
        }
    }

    public void b() {
        h = true;
    }

    public int c() {
        d();
        return g;
    }

    private void d() {
        if (g == 0 || e - d >= f5057c) {
            g = Math.round(((float) (f * f5056b)) / ((float) (e - d)));
            d = e;
            f = 0;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        f++;
        if (d == 0) {
            d = j;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        e = j;
        if (h) {
            Choreographer.getInstance().removeFrameCallback(this);
        } else {
            Choreographer.getInstance().postFrameCallback(this);
        }
    }
}
