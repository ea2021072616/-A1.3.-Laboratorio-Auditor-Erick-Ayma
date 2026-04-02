package m3;

import android.graphics.Typeface;
import y.n;
/* loaded from: classes.dex */
public final class b extends n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p2.a f3966a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f3967b;

    public b(d dVar, p2.a aVar) {
        this.f3967b = dVar;
        this.f3966a = aVar;
    }

    @Override // y.n
    public final void onFontRetrievalFailed(int i5) {
        this.f3967b.f3984m = true;
        this.f3966a.M(i5);
    }

    @Override // y.n
    public final void onFontRetrieved(Typeface typeface) {
        d dVar = this.f3967b;
        dVar.f3985n = Typeface.create(typeface, dVar.f3974c);
        dVar.f3984m = true;
        this.f3966a.N(dVar.f3985n, false);
    }
}
