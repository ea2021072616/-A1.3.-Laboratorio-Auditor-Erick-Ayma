package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i0;
import androidx.recyclerview.widget.i1;
import com.github.appintro.R;
import java.util.Locale;
/* loaded from: classes.dex */
public final class y extends i0 {

    /* renamed from: j  reason: collision with root package name */
    public final l f2165j;

    public y(l lVar) {
        this.f2165j = lVar;
    }

    @Override // androidx.recyclerview.widget.i0
    public final int a() {
        return this.f2165j.f2126i.f2107g;
    }

    @Override // androidx.recyclerview.widget.i0
    public final void d(i1 i1Var, int i5) {
        l lVar = this.f2165j;
        int i6 = lVar.f2126i.f2102b.f2145d + i5;
        String format = String.format(Locale.getDefault(), "%d", Integer.valueOf(i6));
        TextView textView = ((x) i1Var).f2164u;
        textView.setText(format);
        Context context = textView.getContext();
        textView.setContentDescription(w.c().get(1) == i6 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i6)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i6)));
        d dVar = lVar.f2129l;
        if (w.c().get(1) == i6) {
            androidx.appcompat.widget.s sVar = dVar.f2110b;
        } else {
            androidx.appcompat.widget.s sVar2 = dVar.f2109a;
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.i0
    public final i1 e(RecyclerView recyclerView, int i5) {
        return new x((TextView) LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.mtrl_calendar_year, (ViewGroup) recyclerView, false));
    }
}
