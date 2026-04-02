package y1;

import android.content.Context;
import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5661a;

    /* renamed from: b  reason: collision with root package name */
    public final f2.a f5662b;

    /* renamed from: c  reason: collision with root package name */
    public final f2.a f5663c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5664d;

    public b(Context context, f2.a aVar, f2.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f5661a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f5662b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f5663c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f5664d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f5661a.equals(((b) cVar).f5661a)) {
                b bVar = (b) cVar;
                if (this.f5662b.equals(bVar.f5662b) && this.f5663c.equals(bVar.f5663c) && this.f5664d.equals(bVar.f5664d)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f5661a.hashCode() ^ 1000003) * 1000003) ^ this.f5662b.hashCode()) * 1000003) ^ this.f5663c.hashCode()) * 1000003) ^ this.f5664d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f5661a);
        sb.append(", wallClock=");
        sb.append(this.f5662b);
        sb.append(", monotonicClock=");
        sb.append(this.f5663c);
        sb.append(", backendName=");
        return b0.i(sb, this.f5664d, "}");
    }
}
