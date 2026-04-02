package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes.dex */
public final class q1 extends Writer {

    /* renamed from: c  reason: collision with root package name */
    public final StringBuilder f977c = new StringBuilder(128);

    /* renamed from: b  reason: collision with root package name */
    public final String f976b = "FragmentManager";

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        j();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        j();
    }

    public final void j() {
        StringBuilder sb = this.f977c;
        if (sb.length() > 0) {
            Log.d(this.f976b, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c5 = cArr[i5 + i7];
            if (c5 == '\n') {
                j();
            } else {
                this.f977c.append(c5);
            }
        }
    }
}
