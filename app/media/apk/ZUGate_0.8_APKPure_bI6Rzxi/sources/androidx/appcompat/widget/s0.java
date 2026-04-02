package androidx.appcompat.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
/* loaded from: classes.dex */
public final class s0 implements ListAdapter, SpinnerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final SpinnerAdapter f522a;

    /* renamed from: b  reason: collision with root package name */
    public final ListAdapter f523b;

    public s0(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
        this.f522a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f523b = (ListAdapter) spinnerAdapter;
        }
        if (theme == null || !(spinnerAdapter instanceof ThemedSpinnerAdapter)) {
            return;
        }
        q0.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
    }

    @Override // android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f523b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        SpinnerAdapter spinnerAdapter = this.f522a;
        if (spinnerAdapter == null) {
            return 0;
        }
        return spinnerAdapter.getCount();
    }

    @Override // android.widget.SpinnerAdapter
    public final View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        SpinnerAdapter spinnerAdapter = this.f522a;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getDropDownView(i5, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i5) {
        SpinnerAdapter spinnerAdapter = this.f522a;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getItem(i5);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        SpinnerAdapter spinnerAdapter = this.f522a;
        if (spinnerAdapter == null) {
            return -1L;
        }
        return spinnerAdapter.getItemId(i5);
    }

    @Override // android.widget.Adapter
    public final int getItemViewType(int i5) {
        return 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        return getDropDownView(i5, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public final int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public final boolean hasStableIds() {
        SpinnerAdapter spinnerAdapter = this.f522a;
        return spinnerAdapter != null && spinnerAdapter.hasStableIds();
    }

    @Override // android.widget.Adapter
    public final boolean isEmpty() {
        return getCount() == 0;
    }

    @Override // android.widget.ListAdapter
    public final boolean isEnabled(int i5) {
        ListAdapter listAdapter = this.f523b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i5);
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f522a;
        if (spinnerAdapter != null) {
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f522a;
        if (spinnerAdapter != null) {
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
