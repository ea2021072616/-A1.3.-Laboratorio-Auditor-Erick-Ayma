package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f955b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f956c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f957d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArrayList f958e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f959f;

    public n1(int i5, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f955b = i5;
        this.f956c = arrayList;
        this.f957d = arrayList2;
        this.f958e = arrayList3;
        this.f959f = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i5 = 0; i5 < this.f955b; i5++) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            h0.o0.v((View) this.f956c.get(i5), (String) this.f957d.get(i5));
            h0.o0.v((View) this.f958e.get(i5), (String) this.f959f.get(i5));
        }
    }
}
