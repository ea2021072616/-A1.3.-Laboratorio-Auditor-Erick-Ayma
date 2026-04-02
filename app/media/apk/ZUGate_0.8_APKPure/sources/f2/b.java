package f2;

import android.os.SystemClock;
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2817a;

    public final long a() {
        switch (this.f2817a) {
            case 0:
                return SystemClock.elapsedRealtime();
            default:
                return System.currentTimeMillis();
        }
    }
}
