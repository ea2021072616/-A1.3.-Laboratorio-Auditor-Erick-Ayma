package com.fotoable.youtube.music.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.c.a.j;
import com.fotoable.youtube.music.c.b.z;
import com.fotoable.youtube.music.util.s;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import rx.l;
import rx.m;
/* compiled from: BaseFragment.java */
/* loaded from: classes.dex */
public abstract class i extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected View f2320a;

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f2321b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2322c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g;
    private rx.g.b h;

    public abstract int a();

    public abstract void a(View view, @Nullable Bundle bundle);

    public abstract void g();

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return a() != 0 ? layoutInflater.inflate(a(), viewGroup, false) : super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.g = false;
        this.f2320a = view;
        this.f2322c = bundle;
        this.f2321b = ButterKnife.bind(this, this.f2320a);
        g();
        if (getUserVisibleHint() && !this.d) {
            a(this.f2320a, this.f2322c);
            this.d = true;
        }
        this.f = true;
    }

    public boolean k_() {
        return this.d;
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.e = z;
        if (z && !this.d && this.f) {
            this.d = true;
            a(this.f2320a, this.f2322c);
        }
        a(z);
    }

    public void a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.h == null) {
            this.h = new rx.g.b();
        }
        this.h.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l_() {
        if (this.h != null) {
            this.h.unsubscribe();
            this.h = null;
        }
    }

    public boolean d() {
        return this.g;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            this.d = false;
            this.f = false;
            this.g = true;
            this.f2320a = null;
            this.f2322c = null;
            l_();
            if (this.f2321b != null) {
                this.f2321b.unbind();
                this.f2321b = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j e() {
        return com.fotoable.youtube.music.c.a.f.a().a(MusicApplication.c().e()).a(f()).a();
    }

    protected z f() {
        return new z(this);
    }

    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(s.a()).b(new l<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.base.i.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(com.fotoable.youtube.music.e.a aVar) {
                i.this.a(aVar);
            }
        }));
    }

    public void a(com.fotoable.youtube.music.e.a aVar) {
    }
}
