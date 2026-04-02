package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: j  reason: collision with root package name */
    public static final Object f768j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public static volatile m f769k;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock f770a;

    /* renamed from: b  reason: collision with root package name */
    public final l.c f771b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f772c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f773d;

    /* renamed from: e  reason: collision with root package name */
    public final h f774e;

    /* renamed from: f  reason: collision with root package name */
    public final l f775f;

    /* renamed from: g  reason: collision with root package name */
    public final p3.e f776g;

    /* renamed from: h  reason: collision with root package name */
    public final int f777h;

    /* renamed from: i  reason: collision with root package name */
    public final f f778i;

    public m(n nVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f770a = reentrantReadWriteLock;
        this.f772c = 3;
        this.f775f = nVar.f765a;
        int i5 = nVar.f766b;
        this.f777h = i5;
        this.f778i = nVar.f767c;
        this.f773d = new Handler(Looper.getMainLooper());
        this.f771b = new l.c(0);
        this.f776g = new p3.e(12);
        h hVar = new h(this);
        this.f774e = hVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i5 == 0) {
            try {
                this.f772c = 0;
            } catch (Throwable th) {
                this.f770a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                ((m) hVar.f2463h).f775f.a(new g(hVar));
            } catch (Throwable th2) {
                ((m) hVar.f2463h).d(th2);
            }
        }
    }

    public static m a() {
        m mVar;
        synchronized (f768j) {
            mVar = f769k;
            if (!(mVar != null)) {
                throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            }
        }
        return mVar;
    }

    public final int b() {
        this.f770a.readLock().lock();
        try {
            return this.f772c;
        } finally {
            this.f770a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f777h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f770a.writeLock().lock();
        try {
            if (this.f772c == 0) {
                return;
            }
            this.f772c = 0;
            this.f770a.writeLock().unlock();
            h hVar = this.f774e;
            hVar.getClass();
            try {
                ((m) hVar.f2463h).f775f.a(new g(hVar));
            } catch (Throwable th) {
                ((m) hVar.f2463h).d(th);
            }
        } finally {
            this.f770a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f770a.writeLock().lock();
        try {
            this.f772c = 2;
            arrayList.addAll(this.f771b);
            this.f771b.clear();
            this.f770a.writeLock().unlock();
            this.f773d.post(new androidx.activity.h(arrayList, this.f772c, th));
        } catch (Throwable th2) {
            this.f770a.writeLock().unlock();
            throw th2;
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f770a.writeLock().lock();
        try {
            this.f772c = 1;
            arrayList.addAll(this.f771b);
            this.f771b.clear();
            this.f770a.writeLock().unlock();
            this.f773d.post(new androidx.activity.h(this.f772c, arrayList));
        } catch (Throwable th) {
            this.f770a.writeLock().unlock();
            throw th;
        }
    }

    public final CharSequence f(int i5, int i6, CharSequence charSequence) {
        if (b() == 1) {
            if (i5 >= 0) {
                if (i6 >= 0) {
                    p2.a.h("start should be <= than end", i5 <= i6);
                    if (charSequence == null) {
                        return null;
                    }
                    p2.a.h("start should be < than charSequence length", i5 <= charSequence.length());
                    p2.a.h("end should be < than charSequence length", i6 <= charSequence.length());
                    return (charSequence.length() == 0 || i5 == i6) ? charSequence : this.f774e.D(charSequence, i5, i6, false);
                }
                throw new IllegalArgumentException("end cannot be negative");
            }
            throw new IllegalArgumentException("start cannot be negative");
        }
        throw new IllegalStateException("Not initialized yet");
    }

    public final void g(k kVar) {
        if (kVar == null) {
            throw new NullPointerException("initCallback cannot be null");
        }
        this.f770a.writeLock().lock();
        try {
            if (this.f772c != 1 && this.f772c != 2) {
                this.f771b.add(kVar);
            }
            this.f773d.post(new androidx.activity.h(kVar, this.f772c));
        } finally {
            this.f770a.writeLock().unlock();
        }
    }
}
