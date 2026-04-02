package androidx.viewpager.widget;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
public final class i extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f1601a;

    public i(l lVar) {
        this.f1601a = lVar;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.f1601a.dataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f1601a.dataSetChanged();
    }
}
