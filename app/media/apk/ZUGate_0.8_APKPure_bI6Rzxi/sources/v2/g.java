package v2;

import androidx.fragment.app.y;
import l2.h0;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5210a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final h0 f5211b = new h0();

    /* renamed from: c  reason: collision with root package name */
    public boolean f5212c;

    /* renamed from: d  reason: collision with root package name */
    public Object f5213d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f5214e;

    public final void a() {
        boolean z4;
        Exception exc;
        String str;
        boolean z5;
        Object obj;
        if (this.f5212c) {
            int i5 = a.f5204b;
            synchronized (this.f5210a) {
                z4 = this.f5212c;
            }
            if (!z4) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.f5210a) {
                exc = this.f5214e;
            }
            if (exc == null) {
                synchronized (this.f5210a) {
                    z5 = this.f5212c && this.f5214e == null;
                }
                if (z5) {
                    synchronized (this.f5210a) {
                        if (!this.f5212c) {
                            throw new IllegalStateException("Task is not yet complete");
                        }
                        Exception exc2 = this.f5214e;
                        if (exc2 != null) {
                            throw new y(exc2);
                        }
                        obj = this.f5213d;
                    }
                    str = "result ".concat(String.valueOf(obj));
                } else {
                    str = "unknown issue";
                }
            } else {
                str = "failure";
            }
        }
    }
}
