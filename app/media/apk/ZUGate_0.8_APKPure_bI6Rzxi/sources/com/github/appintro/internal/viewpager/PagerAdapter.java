package com.github.appintro.internal.viewpager;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b1;
import androidx.fragment.app.w0;
import e4.e;
import java.util.List;
/* loaded from: classes.dex */
public final class PagerAdapter extends b1 {
    private final List<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerAdapter(w0 w0Var, List<Fragment> list) {
        super(w0Var);
        e.f(w0Var, "fragmentManager");
        e.f(list, "fragments");
        this.fragments = list;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.b1
    public Fragment getItem(int i5) {
        return this.fragments.get(i5);
    }

    @Override // androidx.fragment.app.b1, androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i5) {
        e.f(viewGroup, "container");
        Object instantiateItem = super.instantiateItem(viewGroup, i5);
        this.fragments.set(i5, (Fragment) instantiateItem);
        return instantiateItem;
    }
}
