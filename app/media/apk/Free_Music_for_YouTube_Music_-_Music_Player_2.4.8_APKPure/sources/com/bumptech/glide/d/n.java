package com.bumptech.glide.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.HashSet;
/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class n extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private com.bumptech.glide.l f661a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.d.a f662b;

    /* renamed from: c  reason: collision with root package name */
    private final l f663c;
    private final HashSet<n> d;
    private n e;

    public n() {
        this(new com.bumptech.glide.d.a());
    }

    @SuppressLint({"ValidFragment"})
    public n(com.bumptech.glide.d.a aVar) {
        this.f663c = new a();
        this.d = new HashSet<>();
        this.f662b = aVar;
    }

    public void a(com.bumptech.glide.l lVar) {
        this.f661a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.d.a a() {
        return this.f662b;
    }

    public com.bumptech.glide.l b() {
        return this.f661a;
    }

    public l c() {
        return this.f663c;
    }

    private void a(n nVar) {
        this.d.add(nVar);
    }

    private void b(n nVar) {
        this.d.remove(nVar);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.e = k.a().a(getActivity().getSupportFragmentManager());
        if (this.e != this) {
            this.e.a(this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f662b.a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f662b.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f662b.c();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (this.f661a != null) {
            this.f661a.a();
        }
    }

    /* compiled from: SupportRequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements l {
        private a() {
        }
    }
}
