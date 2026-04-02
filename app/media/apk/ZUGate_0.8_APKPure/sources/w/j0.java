package w;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class j0 implements Iterable {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f5264b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Context f5265c;

    public j0(Context context) {
        this.f5265c = context;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f5264b.iterator();
    }
}
