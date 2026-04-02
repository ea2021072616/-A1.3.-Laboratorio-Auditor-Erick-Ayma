package a4;

import androidx.activity.s;
import java.io.Serializable;
import l2.i;
/* loaded from: classes.dex */
public final class c implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public i4.a f31b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Object f32c = i.f3854h;

    /* renamed from: d  reason: collision with root package name */
    public final Object f33d = this;

    public c(s sVar) {
        this.f31b = sVar;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f32c;
        i iVar = i.f3854h;
        if (obj2 != iVar) {
            return obj2;
        }
        synchronized (this.f33d) {
            obj = this.f32c;
            if (obj == iVar) {
                i4.a aVar = this.f31b;
                e4.e.c(aVar);
                obj = aVar.a();
                this.f32c = obj;
                this.f31b = null;
            }
        }
        return obj;
    }

    public final String toString() {
        return this.f32c != i.f3854h ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
