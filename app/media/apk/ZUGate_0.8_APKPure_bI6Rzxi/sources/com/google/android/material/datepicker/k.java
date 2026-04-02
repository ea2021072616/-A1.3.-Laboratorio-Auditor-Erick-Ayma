package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v0;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public final class k extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f2121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f2122b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f2123c;

    public k(l lVar, t tVar, MaterialButton materialButton) {
        this.f2123c = lVar;
        this.f2121a = tVar;
        this.f2122b = materialButton;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void a(RecyclerView recyclerView, int i5) {
        if (i5 == 0) {
            recyclerView.announceForAccessibility(this.f2122b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.v0
    public final void b(RecyclerView recyclerView, int i5, int i6) {
        l lVar = this.f2123c;
        int M0 = i5 < 0 ? ((LinearLayoutManager) lVar.f2131n.getLayoutManager()).M0() : ((LinearLayoutManager) lVar.f2131n.getLayoutManager()).N0();
        t tVar = this.f2121a;
        Calendar b5 = w.b(tVar.f2159j.f2102b.f2143b);
        b5.add(2, M0);
        lVar.f2127j = new p(b5);
        Calendar b6 = w.b(tVar.f2159j.f2102b.f2143b);
        b6.add(2, M0);
        b6.set(5, 1);
        Calendar b7 = w.b(b6);
        b7.get(2);
        b7.get(1);
        b7.getMaximum(7);
        b7.getActualMaximum(5);
        b7.getTimeInMillis();
        this.f2122b.setText(w.a("yMMMM", Locale.getDefault()).format(new Date(b7.getTimeInMillis())));
    }
}
