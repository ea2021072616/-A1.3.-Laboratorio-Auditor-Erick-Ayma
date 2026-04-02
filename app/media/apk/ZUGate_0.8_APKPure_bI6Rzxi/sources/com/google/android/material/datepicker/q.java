package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class q extends BaseAdapter {

    /* renamed from: d  reason: collision with root package name */
    public static final int f2150d = w.d(null).getMaximum(4);

    /* renamed from: e  reason: collision with root package name */
    public static final int f2151e = (w.d(null).getMaximum(7) + w.d(null).getMaximum(5)) - 1;

    /* renamed from: a  reason: collision with root package name */
    public final p f2152a;

    /* renamed from: b  reason: collision with root package name */
    public d f2153b;

    /* renamed from: c  reason: collision with root package name */
    public final c f2154c;

    public q(p pVar, c cVar) {
        this.f2152a = pVar;
        this.f2154c = cVar;
        throw null;
    }

    public final int a() {
        int i5 = this.f2154c.f2106f;
        p pVar = this.f2152a;
        Calendar calendar = pVar.f2143b;
        int i6 = calendar.get(7);
        if (i5 <= 0) {
            i5 = calendar.getFirstDayOfWeek();
        }
        int i7 = i6 - i5;
        return i7 < 0 ? i7 + pVar.f2146e : i7;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public final Long getItem(int i5) {
        if (i5 >= a()) {
            int a5 = a();
            p pVar = this.f2152a;
            if (i5 > (a5 + pVar.f2147f) - 1) {
                return null;
            }
            Calendar b5 = w.b(pVar.f2143b);
            b5.set(5, (i5 - a()) + 1);
            return Long.valueOf(b5.getTimeInMillis());
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f2151e;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        return i5 / this.f2152a.f2146e;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            android.content.Context r0 = r7.getContext()
            com.google.android.material.datepicker.d r1 = r4.f2153b
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.d r1 = new com.google.android.material.datepicker.d
            r1.<init>(r0)
            r4.f2153b = r1
        Lf:
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r6 != 0) goto L27
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            r0 = 2131492955(0x7f0c005b, float:1.8609377E38)
            android.view.View r6 = r6.inflate(r0, r7, r1)
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r6 = r4.a()
            int r6 = r5 - r6
            if (r6 < 0) goto L5d
            com.google.android.material.datepicker.p r7 = r4.f2152a
            int r2 = r7.f2147f
            if (r6 < r2) goto L36
            goto L5d
        L36:
            r2 = 1
            int r6 = r6 + r2
            r0.setTag(r7)
            android.content.res.Resources r7 = r0.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r3 = "%d"
            java.lang.String r6 = java.lang.String.format(r7, r3, r6)
            r0.setText(r6)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L65
        L5d:
            r6 = 8
            r0.setVisibility(r6)
            r0.setEnabled(r1)
        L65:
            java.lang.Long r5 = r4.getItem(r5)
            if (r5 != 0) goto L6c
            goto L71
        L6c:
            r5.longValue()
            if (r0 != 0) goto L72
        L71:
            return r0
        L72:
            r0.getContext()
            java.util.Calendar r5 = com.google.android.material.datepicker.w.c()
            r5.getTimeInMillis()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.q.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
