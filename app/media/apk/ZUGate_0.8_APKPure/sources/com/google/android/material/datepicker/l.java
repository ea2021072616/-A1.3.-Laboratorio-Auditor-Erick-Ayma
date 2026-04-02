package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.appcompat.widget.b0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f0;
import androidx.recyclerview.widget.l1;
import com.github.appintro.R;
import com.google.android.material.button.MaterialButton;
import h0.z0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* loaded from: classes.dex */
public final class l<S> extends u {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f2124s = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f2125h;

    /* renamed from: i  reason: collision with root package name */
    public c f2126i;

    /* renamed from: j  reason: collision with root package name */
    public p f2127j;

    /* renamed from: k  reason: collision with root package name */
    public int f2128k;

    /* renamed from: l  reason: collision with root package name */
    public d f2129l;

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView f2130m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f2131n;
    public View o;

    /* renamed from: p  reason: collision with root package name */
    public View f2132p;

    /* renamed from: q  reason: collision with root package name */
    public View f2133q;

    /* renamed from: r  reason: collision with root package name */
    public View f2134r;

    public final void g(p pVar) {
        p pVar2 = ((t) this.f2131n.getAdapter()).f2159j.f2102b;
        Calendar calendar = pVar2.f2143b;
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i5 = pVar.f2145d;
        int i6 = pVar2.f2145d;
        int i7 = pVar.f2144c;
        int i8 = pVar2.f2144c;
        int i9 = (i7 - i8) + ((i5 - i6) * 12);
        p pVar3 = this.f2127j;
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i10 = i9 - ((pVar3.f2144c - i8) + ((pVar3.f2145d - i6) * 12));
        boolean z4 = Math.abs(i10) > 3;
        boolean z5 = i10 > 0;
        this.f2127j = pVar;
        if (z4 && z5) {
            this.f2131n.f0(i9 - 3);
            this.f2131n.post(new k2.m(i9, 1, this));
        } else if (!z4) {
            this.f2131n.post(new k2.m(i9, 1, this));
        } else {
            this.f2131n.f0(i9 + 3);
            this.f2131n.post(new k2.m(i9, 1, this));
        }
    }

    public final void h(int i5) {
        this.f2128k = i5;
        if (i5 == 2) {
            this.f2130m.getLayoutManager().p0(this.f2127j.f2145d - ((y) this.f2130m.getAdapter()).f2165j.f2126i.f2102b.f2145d);
            this.f2133q.setVisibility(0);
            this.f2134r.setVisibility(8);
            this.o.setVisibility(8);
            this.f2132p.setVisibility(8);
        } else if (i5 == 1) {
            this.f2133q.setVisibility(8);
            this.f2134r.setVisibility(0);
            this.o.setVisibility(0);
            this.f2132p.setVisibility(0);
            g(this.f2127j);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f2125h = bundle.getInt("THEME_RES_ID_KEY");
        b0.j(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f2126i = (c) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        b0.j(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f2127j = (p) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5;
        int i6;
        f0 f0Var;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f2125h);
        this.f2129l = new d(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        p pVar = this.f2126i.f2102b;
        if (n.m(contextThemeWrapper)) {
            i5 = R.layout.mtrl_calendar_vertical;
            i6 = 1;
        } else {
            i5 = R.layout.mtrl_calendar_horizontal;
            i6 = 0;
        }
        View inflate = cloneInContext.inflate(i5, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i7 = q.f2150d;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i7 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i7) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        z0.n(gridView, new h(0, this));
        int i8 = this.f2126i.f2106f;
        gridView.setAdapter((ListAdapter) (i8 > 0 ? new f(i8) : new f()));
        gridView.setNumColumns(pVar.f2146e);
        gridView.setEnabled(false);
        this.f2131n = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        getContext();
        this.f2131n.setLayoutManager(new i(this, i6, i6));
        this.f2131n.setTag("MONTHS_VIEW_GROUP_TAG");
        t tVar = new t(contextThemeWrapper, this.f2126i, new n2.b(this));
        this.f2131n.setAdapter(tVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f2130m = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f2130m.setLayoutManager(new GridLayoutManager(integer));
            this.f2130m.setAdapter(new y(this));
            this.f2130m.i(new j(this));
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            z0.n(materialButton, new h(2, this));
            View findViewById = inflate.findViewById(R.id.month_navigation_previous);
            this.o = findViewById;
            findViewById.setTag("NAVIGATION_PREV_TAG");
            View findViewById2 = inflate.findViewById(R.id.month_navigation_next);
            this.f2132p = findViewById2;
            findViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f2133q = inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
            this.f2134r = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            h(1);
            materialButton.setText(this.f2127j.c());
            this.f2131n.j(new k(this, tVar, materialButton));
            materialButton.setOnClickListener(new d.d(4, this));
            this.f2132p.setOnClickListener(new g(this, tVar, 1));
            this.o.setOnClickListener(new g(this, tVar, 0));
        }
        if (!n.m(contextThemeWrapper) && (recyclerView2 = (f0Var = new f0()).f1341a) != (recyclerView = this.f2131n)) {
            l1 l1Var = f0Var.f1342b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f1236o0;
                if (arrayList != null) {
                    arrayList.remove(l1Var);
                }
                f0Var.f1341a.setOnFlingListener(null);
            }
            f0Var.f1341a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                f0Var.f1341a.j(l1Var);
                f0Var.f1341a.setOnFlingListener(f0Var);
                new Scroller(f0Var.f1341a.getContext(), new DecelerateInterpolator());
                f0Var.f();
            }
        }
        RecyclerView recyclerView4 = this.f2131n;
        p pVar2 = this.f2127j;
        p pVar3 = tVar.f2159j.f2102b;
        if (pVar3.f2143b instanceof GregorianCalendar) {
            recyclerView4.f0((pVar2.f2144c - pVar3.f2144c) + ((pVar2.f2145d - pVar3.f2145d) * 12));
            z0.n(this.f2131n, new h(1, this));
            return inflate;
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f2125h);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2126i);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2127j);
    }
}
