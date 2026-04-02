package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public final class r implements AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f2155g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ t f2156h;

    public r(t tVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f2156h = tVar;
        this.f2155g = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        MaterialCalendarGridView materialCalendarGridView = this.f2155g;
        q adapter2 = materialCalendarGridView.getAdapter2();
        if (i5 >= adapter2.a() && i5 <= (adapter2.a() + adapter2.f2152a.f2147f) + (-1)) {
            n2.b bVar = this.f2156h.f2160k;
            long longValue = materialCalendarGridView.getAdapter2().getItem(i5).longValue();
            Object obj = bVar.f4085g;
            if (longValue >= ((e) ((l) obj).f2126i.f2104d).f2111b) {
                ((l) obj).getClass();
                throw null;
            }
        }
    }
}
