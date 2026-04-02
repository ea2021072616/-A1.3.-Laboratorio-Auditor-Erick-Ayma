package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i0;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.s0;
import com.github.appintro.R;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class t extends i0 {

    /* renamed from: j  reason: collision with root package name */
    public final c f2159j;

    /* renamed from: k  reason: collision with root package name */
    public final n2.b f2160k;

    /* renamed from: l  reason: collision with root package name */
    public final int f2161l;

    public t(ContextThemeWrapper contextThemeWrapper, c cVar, n2.b bVar) {
        Calendar calendar = cVar.f2102b.f2143b;
        p pVar = cVar.f2105e;
        if (calendar.compareTo(pVar.f2143b) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (pVar.f2143b.compareTo(cVar.f2103c.f2143b) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int i5 = q.f2150d;
        int i6 = l.f2124s;
        this.f2161l = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i5) + (n.m(contextThemeWrapper) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f2159j = cVar;
        this.f2160k = bVar;
        f(true);
    }

    @Override // androidx.recyclerview.widget.i0
    public final int a() {
        return this.f2159j.f2108h;
    }

    @Override // androidx.recyclerview.widget.i0
    public final long b(int i5) {
        Calendar b5 = w.b(this.f2159j.f2102b.f2143b);
        b5.add(2, i5);
        return new p(b5).f2143b.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.i0
    public final void d(i1 i1Var, int i5) {
        s sVar = (s) i1Var;
        c cVar = this.f2159j;
        Calendar b5 = w.b(cVar.f2102b.f2143b);
        b5.add(2, i5);
        p pVar = new p(b5);
        sVar.f2157u.setText(pVar.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) sVar.f2158v.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter2() == null || !pVar.equals(materialCalendarGridView.getAdapter2().f2152a)) {
            new q(pVar, cVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.getAdapter2().getClass();
        throw null;
    }

    @Override // androidx.recyclerview.widget.i0
    public final i1 e(RecyclerView recyclerView, int i5) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, (ViewGroup) recyclerView, false);
        if (n.m(recyclerView.getContext())) {
            linearLayout.setLayoutParams(new s0(-1, this.f2161l));
            return new s(linearLayout, true);
        }
        return new s(linearLayout, false);
    }
}
