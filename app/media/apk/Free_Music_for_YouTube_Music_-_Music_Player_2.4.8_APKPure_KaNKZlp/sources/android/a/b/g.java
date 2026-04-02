package android.a.b;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
/* compiled from: Lifecycle.java */
/* loaded from: classes.dex */
public abstract class g {

    /* compiled from: Lifecycle.java */
    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    @MainThread
    public abstract b a();

    /* compiled from: Lifecycle.java */
    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(@NonNull b bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
