package androidx.emoji2.text;

import android.os.Trace;
/* loaded from: classes.dex */
public final class q implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i5 = d0.j.f2506a;
            Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (m.f769k != null) {
                m.a().c();
            }
            Trace.endSection();
        } catch (Throwable th) {
            int i6 = d0.j.f2506a;
            Trace.endSection();
            throw th;
        }
    }
}
