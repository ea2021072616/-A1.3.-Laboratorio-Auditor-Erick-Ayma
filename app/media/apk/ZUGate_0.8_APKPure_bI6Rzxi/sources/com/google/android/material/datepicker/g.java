package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2115g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ t f2116h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f2117i;

    public /* synthetic */ g(l lVar, t tVar, int i5) {
        this.f2115g = i5;
        this.f2117i = lVar;
        this.f2116h = tVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = this.f2115g;
        t tVar = this.f2116h;
        l lVar = this.f2117i;
        switch (i5) {
            case 0:
                int N0 = ((LinearLayoutManager) lVar.f2131n.getLayoutManager()).N0() - 1;
                if (N0 >= 0) {
                    Calendar b5 = w.b(tVar.f2159j.f2102b.f2143b);
                    b5.add(2, N0);
                    lVar.g(new p(b5));
                    return;
                }
                return;
            default:
                int M0 = ((LinearLayoutManager) lVar.f2131n.getLayoutManager()).M0() + 1;
                if (M0 < lVar.f2131n.getAdapter().a()) {
                    Calendar b6 = w.b(tVar.f2159j.f2102b.f2143b);
                    b6.add(2, M0);
                    lVar.g(new p(b6));
                    return;
                }
                return;
        }
    }
}
