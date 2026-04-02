package l2;

import java.io.Serializable;
import java.util.Queue;
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3850a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3851b;

    /* renamed from: c  reason: collision with root package name */
    public Serializable f3852c;

    public h0() {
        this.f3851b = new Object();
    }

    public final void a(v2.g gVar) {
        v2.f fVar;
        synchronized (this.f3851b) {
            if (((Queue) this.f3852c) != null && !this.f3850a) {
                this.f3850a = true;
                while (true) {
                    synchronized (this.f3851b) {
                        fVar = (v2.f) ((Queue) this.f3852c).poll();
                        if (fVar == null) {
                            this.f3850a = false;
                            return;
                        }
                    }
                    v2.e eVar = (v2.e) fVar;
                    synchronized (eVar.f5208b) {
                        if (eVar.f5209c != null) {
                            eVar.f5207a.execute(new androidx.appcompat.widget.k(eVar, 13, gVar));
                        }
                    }
                }
            }
        }
    }

    public h0(String str, boolean z4) {
        this.f3852c = "com.google.android.gms";
        this.f3851b = str;
        this.f3850a = z4;
    }
}
