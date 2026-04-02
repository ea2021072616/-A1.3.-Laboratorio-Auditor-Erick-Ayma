package y1;

import android.content.Context;
import androidx.appcompat.widget.d0;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final d0 f5672a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5673b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f5674c;

    public f(Context context, d dVar) {
        d0 d0Var = new d0(13, context);
        this.f5674c = new HashMap();
        this.f5672a = d0Var;
        this.f5673b = dVar;
    }

    public final synchronized g a(String str) {
        if (this.f5674c.containsKey(str)) {
            return (g) this.f5674c.get(str);
        }
        CctBackendFactory h5 = this.f5672a.h(str);
        if (h5 == null) {
            return null;
        }
        d dVar = this.f5673b;
        g create = h5.create(new b(dVar.f5665a, dVar.f5666b, dVar.f5667c, str));
        this.f5674c.put(str, create);
        return create;
    }
}
