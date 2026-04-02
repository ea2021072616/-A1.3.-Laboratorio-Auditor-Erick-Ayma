package m3;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
/* loaded from: classes.dex */
public final class c extends p2.a {

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Context f3968u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ TextPaint f3969v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ p2.a f3970w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ d f3971x;

    public c(d dVar, Context context, TextPaint textPaint, p2.a aVar) {
        this.f3971x = dVar;
        this.f3968u = context;
        this.f3969v = textPaint;
        this.f3970w = aVar;
    }

    @Override // p2.a
    public final void M(int i5) {
        this.f3970w.M(i5);
    }

    @Override // p2.a
    public final void N(Typeface typeface, boolean z4) {
        this.f3971x.g(this.f3968u, this.f3969v, typeface);
        this.f3970w.N(typeface, z4);
    }
}
