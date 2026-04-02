package androidx.fragment.app;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f924b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f925c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f926d;

    public /* synthetic */ j(Object obj, int i5, Object obj2) {
        this.f924b = i5;
        this.f926d = obj;
        this.f925c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f924b;
        Object obj = this.f925c;
        switch (i5) {
            case 0:
                h1.a((ArrayList) obj, 4);
                return;
            default:
                ((t1) obj).c();
                return;
        }
    }
}
