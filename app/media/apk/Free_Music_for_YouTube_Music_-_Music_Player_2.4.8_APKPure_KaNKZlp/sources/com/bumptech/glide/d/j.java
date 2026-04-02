package com.bumptech.glide.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import java.util.HashSet;
/* compiled from: RequestManagerFragment.java */
@TargetApi(11)
/* loaded from: classes.dex */
public class j extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.d.a f651a;

    /* renamed from: b  reason: collision with root package name */
    private final l f652b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.l f653c;
    private final HashSet<j> d;
    private j e;

    public j() {
        this(new com.bumptech.glide.d.a());
    }

    @SuppressLint({"ValidFragment"})
    j(com.bumptech.glide.d.a aVar) {
        this.f652b = new a();
        this.d = new HashSet<>();
        this.f651a = aVar;
    }

    public void a(com.bumptech.glide.l lVar) {
        this.f653c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.d.a a() {
        return this.f651a;
    }

    public com.bumptech.glide.l b() {
        return this.f653c;
    }

    public l c() {
        return this.f652b;
    }

    private void a(j jVar) {
        this.d.add(jVar);
    }

    private void b(j jVar) {
        this.d.remove(jVar);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.e = k.a().a(getActivity().getFragmentManager());
        if (this.e != this) {
            this.e.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f651a.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f651a.b();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f651a.c();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (this.f653c != null) {
            this.f653c.a(i);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.f653c != null) {
            this.f653c.a();
        }
    }

    /* compiled from: RequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements l {
        private a() {
        }
    }
}
