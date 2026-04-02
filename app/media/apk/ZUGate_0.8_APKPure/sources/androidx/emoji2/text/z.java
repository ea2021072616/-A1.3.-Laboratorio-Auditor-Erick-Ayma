package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Trace;
import com.google.android.gms.internal.play_billing.i0;
import java.nio.MappedByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class z implements l {

    /* renamed from: a  reason: collision with root package name */
    public final Context f804a;

    /* renamed from: b  reason: collision with root package name */
    public final androidx.appcompat.widget.s f805b;

    /* renamed from: c  reason: collision with root package name */
    public final p3.e f806c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f807d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f808e;

    /* renamed from: f  reason: collision with root package name */
    public Executor f809f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadPoolExecutor f810g;

    /* renamed from: h  reason: collision with root package name */
    public b4.j f811h;

    /* renamed from: i  reason: collision with root package name */
    public y f812i;

    public z(Context context, androidx.appcompat.widget.s sVar) {
        p3.e eVar = n.f779d;
        this.f807d = new Object();
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.f804a = context.getApplicationContext();
        this.f805b = sVar;
        this.f806c = eVar;
    }

    @Override // androidx.emoji2.text.l
    public final void a(b4.j jVar) {
        synchronized (this.f807d) {
            this.f811h = jVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f807d) {
            this.f811h = null;
            y yVar = this.f812i;
            if (yVar != null) {
                p3.e eVar = this.f806c;
                Context context = this.f804a;
                eVar.getClass();
                context.getContentResolver().unregisterContentObserver(yVar);
                this.f812i = null;
            }
            Handler handler = this.f808e;
            if (handler != null) {
                handler.removeCallbacks(null);
            }
            this.f808e = null;
            ThreadPoolExecutor threadPoolExecutor = this.f810g;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdown();
            }
            this.f809f = null;
            this.f810g = null;
        }
    }

    public final void c() {
        synchronized (this.f807d) {
            if (this.f811h == null) {
                return;
            }
            if (this.f809f == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                this.f810g = threadPoolExecutor;
                this.f809f = threadPoolExecutor;
            }
            this.f809f.execute(new Runnable(this) { // from class: androidx.emoji2.text.x

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ z f801c;

                {
                    this.f801c = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (r2) {
                        case 0:
                            z zVar = this.f801c;
                            synchronized (zVar.f807d) {
                                if (zVar.f811h == null) {
                                    return;
                                }
                                try {
                                    e0.g d5 = zVar.d();
                                    int i5 = d5.f2581e;
                                    if (i5 == 2) {
                                        synchronized (zVar.f807d) {
                                        }
                                    }
                                    if (i5 != 0) {
                                        throw new RuntimeException("fetchFonts result is not OK. (" + i5 + ")");
                                    }
                                    int i6 = d0.j.f2506a;
                                    Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                    p3.e eVar = zVar.f806c;
                                    Context context = zVar.f804a;
                                    eVar.getClass();
                                    Typeface w5 = z.g.f5756a.w(context, new e0.g[]{d5}, 0);
                                    MappedByteBuffer s5 = m0.a.s(zVar.f804a, d5.f2577a);
                                    if (s5 == null || w5 == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        g.f fVar = new g.f(w5, i0.M(s5));
                                        Trace.endSection();
                                        Trace.endSection();
                                        synchronized (zVar.f807d) {
                                            b4.j jVar = zVar.f811h;
                                            if (jVar != null) {
                                                jVar.F(fVar);
                                            }
                                        }
                                        zVar.b();
                                        return;
                                    } catch (Throwable th) {
                                        int i7 = d0.j.f2506a;
                                        Trace.endSection();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    synchronized (zVar.f807d) {
                                        b4.j jVar2 = zVar.f811h;
                                        if (jVar2 != null) {
                                            jVar2.E(th2);
                                        }
                                        zVar.b();
                                        return;
                                    }
                                }
                            }
                        default:
                            this.f801c.c();
                            return;
                    }
                }
            });
        }
    }

    public final e0.g d() {
        try {
            p3.e eVar = this.f806c;
            Context context = this.f804a;
            androidx.appcompat.widget.s sVar = this.f805b;
            eVar.getClass();
            d.m t5 = b4.j.t(context, sVar);
            if (t5.f2397g != 0) {
                throw new RuntimeException("fetchFonts failed (" + t5.f2397g + ")");
            }
            e0.g[] gVarArr = (e0.g[]) t5.f2398h;
            if (gVarArr == null || gVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return gVarArr[0];
        } catch (PackageManager.NameNotFoundException e5) {
            throw new RuntimeException("provider not found", e5);
        }
    }
}
