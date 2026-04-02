package com.facebook.ads.internal.view.hscroll;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<int[]> f1747a = new SparseArray<>();

    public void a(int i, int[] iArr) {
        this.f1747a.put(i, iArr);
    }

    public int[] a(int i) {
        return this.f1747a.get(i);
    }

    public boolean b(int i) {
        return this.f1747a.indexOfKey(i) >= 0;
    }
}
