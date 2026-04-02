package p3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f4314a;

    /* renamed from: b  reason: collision with root package name */
    public final i0 f4315b;

    /* renamed from: c  reason: collision with root package name */
    public final i0 f4316c;

    /* renamed from: d  reason: collision with root package name */
    public final i0 f4317d;

    /* renamed from: e  reason: collision with root package name */
    public final c f4318e;

    /* renamed from: f  reason: collision with root package name */
    public final c f4319f;

    /* renamed from: g  reason: collision with root package name */
    public final c f4320g;

    /* renamed from: h  reason: collision with root package name */
    public final c f4321h;

    /* renamed from: i  reason: collision with root package name */
    public final e f4322i;

    /* renamed from: j  reason: collision with root package name */
    public final e f4323j;

    /* renamed from: k  reason: collision with root package name */
    public final e f4324k;

    /* renamed from: l  reason: collision with root package name */
    public final e f4325l;

    public j(w1.h hVar) {
        this.f4314a = (i0) hVar.f5334a;
        this.f4315b = (i0) hVar.f5335b;
        this.f4316c = (i0) hVar.f5336c;
        this.f4317d = (i0) hVar.f5337d;
        this.f4318e = (c) hVar.f5338e;
        this.f4319f = (c) hVar.f5339f;
        this.f4320g = (c) hVar.f5340g;
        this.f4321h = (c) hVar.f5341h;
        this.f4322i = (e) hVar.f5342i;
        this.f4323j = (e) hVar.f5343j;
        this.f4324k = (e) hVar.f5344k;
        this.f4325l = (e) hVar.f5345l;
    }

    public static w1.h a(Context context, int i5, int i6, a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i5);
        if (i6 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i6);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(w2.a.f5406v);
        try {
            int i7 = obtainStyledAttributes.getInt(0, 0);
            int i8 = obtainStyledAttributes.getInt(3, i7);
            int i9 = obtainStyledAttributes.getInt(4, i7);
            int i10 = obtainStyledAttributes.getInt(2, i7);
            int i11 = obtainStyledAttributes.getInt(1, i7);
            c c5 = c(obtainStyledAttributes, 5, aVar);
            c c6 = c(obtainStyledAttributes, 8, c5);
            c c7 = c(obtainStyledAttributes, 9, c5);
            c c8 = c(obtainStyledAttributes, 7, c5);
            c c9 = c(obtainStyledAttributes, 6, c5);
            w1.h hVar = new w1.h(1);
            i0 n5 = p2.a.n(i8);
            hVar.f5334a = n5;
            w1.h.b(n5);
            hVar.f5338e = c6;
            i0 n6 = p2.a.n(i9);
            hVar.f5335b = n6;
            w1.h.b(n6);
            hVar.f5339f = c7;
            i0 n7 = p2.a.n(i10);
            hVar.f5336c = n7;
            w1.h.b(n7);
            hVar.f5340g = c8;
            i0 n8 = p2.a.n(i11);
            hVar.f5337d = n8;
            w1.h.b(n8);
            hVar.f5341h = c9;
            return hVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static w1.h b(Context context, AttributeSet attributeSet, int i5, int i6) {
        a aVar = new a(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5400p, i5, i6);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i5, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i5);
        if (peekValue == null) {
            return cVar;
        }
        int i6 = peekValue.type;
        return i6 == 5 ? new a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i6 == 6 ? new h(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public final boolean d(RectF rectF) {
        boolean z4 = this.f4325l.getClass().equals(e.class) && this.f4323j.getClass().equals(e.class) && this.f4322i.getClass().equals(e.class) && this.f4324k.getClass().equals(e.class);
        float a5 = this.f4318e.a(rectF);
        return z4 && ((this.f4319f.a(rectF) > a5 ? 1 : (this.f4319f.a(rectF) == a5 ? 0 : -1)) == 0 && (this.f4321h.a(rectF) > a5 ? 1 : (this.f4321h.a(rectF) == a5 ? 0 : -1)) == 0 && (this.f4320g.a(rectF) > a5 ? 1 : (this.f4320g.a(rectF) == a5 ? 0 : -1)) == 0) && ((this.f4315b instanceof i) && (this.f4314a instanceof i) && (this.f4316c instanceof i) && (this.f4317d instanceof i));
    }

    public j() {
        this.f4314a = new i();
        this.f4315b = new i();
        this.f4316c = new i();
        this.f4317d = new i();
        this.f4318e = new a(0.0f);
        this.f4319f = new a(0.0f);
        this.f4320g = new a(0.0f);
        this.f4321h = new a(0.0f);
        this.f4322i = p2.a.o();
        this.f4323j = p2.a.o();
        this.f4324k = p2.a.o();
        this.f4325l = p2.a.o();
    }
}
