package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e0;
import androidx.recyclerview.widget.e1;
/* loaded from: classes.dex */
public final class i extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ l F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(l lVar, int i5, int i6) {
        super(i5);
        this.F = lVar;
        this.E = i6;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void C0(e1 e1Var, int[] iArr) {
        int i5 = this.E;
        l lVar = this.F;
        if (i5 == 0) {
            iArr[0] = lVar.f2131n.getWidth();
            iArr[1] = lVar.f2131n.getWidth();
            return;
        }
        iArr[0] = lVar.f2131n.getHeight();
        iArr[1] = lVar.f2131n.getHeight();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final void z0(RecyclerView recyclerView, int i5) {
        e0 e0Var = new e0(this, recyclerView.getContext(), 2);
        e0Var.f1274a = i5;
        A0(e0Var);
    }
}
