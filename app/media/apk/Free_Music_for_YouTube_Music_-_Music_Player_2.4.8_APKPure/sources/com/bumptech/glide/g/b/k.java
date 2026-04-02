package com.bumptech.glide.g.b;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ViewTarget.java */
/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends com.bumptech.glide.g.b.a<Z> {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f703b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Integer f704c = null;

    /* renamed from: a  reason: collision with root package name */
    protected final T f705a;
    private final a d;

    public k(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f705a = t;
        this.d = new a(t);
    }

    public T a() {
        return this.f705a;
    }

    @Override // com.bumptech.glide.g.b.j
    public void getSize(h hVar) {
        this.d.a(hVar);
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
    public void setRequest(com.bumptech.glide.g.b bVar) {
        a(bVar);
    }

    @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
    public com.bumptech.glide.g.b getRequest() {
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        if (c2 instanceof com.bumptech.glide.g.b) {
            return (com.bumptech.glide.g.b) c2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    private void a(Object obj) {
        if (f704c == null) {
            f703b = true;
            this.f705a.setTag(obj);
            return;
        }
        this.f705a.setTag(f704c.intValue(), obj);
    }

    private Object c() {
        return f704c == null ? this.f705a.getTag() : this.f705a.getTag(f704c.intValue());
    }

    public String toString() {
        return "Target for: " + this.f705a;
    }

    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final View f706a;

        /* renamed from: b  reason: collision with root package name */
        private final List<h> f707b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0023a f708c;
        private Point d;

        public a(View view) {
            this.f706a = view;
        }

        private void a(int i, int i2) {
            for (h hVar : this.f707b) {
                hVar.a(i, i2);
            }
            this.f707b.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (!this.f707b.isEmpty()) {
                int c2 = c();
                int b2 = b();
                if (a(c2) && a(b2)) {
                    a(c2, b2);
                    ViewTreeObserver viewTreeObserver = this.f706a.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this.f708c);
                    }
                    this.f708c = null;
                }
            }
        }

        public void a(h hVar) {
            int c2 = c();
            int b2 = b();
            if (a(c2) && a(b2)) {
                hVar.a(c2, b2);
                return;
            }
            if (!this.f707b.contains(hVar)) {
                this.f707b.add(hVar);
            }
            if (this.f708c == null) {
                ViewTreeObserver viewTreeObserver = this.f706a.getViewTreeObserver();
                this.f708c = new ViewTreeObserver$OnPreDrawListenerC0023a(this);
                viewTreeObserver.addOnPreDrawListener(this.f708c);
            }
        }

        private int b() {
            ViewGroup.LayoutParams layoutParams = this.f706a.getLayoutParams();
            if (a(this.f706a.getHeight())) {
                return this.f706a.getHeight();
            }
            if (layoutParams != null) {
                return a(layoutParams.height, true);
            }
            return 0;
        }

        private int c() {
            ViewGroup.LayoutParams layoutParams = this.f706a.getLayoutParams();
            if (a(this.f706a.getWidth())) {
                return this.f706a.getWidth();
            }
            if (layoutParams != null) {
                return a(layoutParams.width, false);
            }
            return 0;
        }

        private int a(int i, boolean z) {
            if (i == -2) {
                Point d = d();
                return z ? d.y : d.x;
            }
            return i;
        }

        @TargetApi(13)
        private Point d() {
            if (this.d != null) {
                return this.d;
            }
            Display defaultDisplay = ((WindowManager) this.f706a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                this.d = new Point();
                defaultDisplay.getSize(this.d);
            } else {
                this.d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.d;
        }

        private boolean a(int i) {
            return i > 0 || i == -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.g.b.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class ViewTreeObserver$OnPreDrawListenerC0023a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f709a;

            public ViewTreeObserver$OnPreDrawListenerC0023a(a aVar) {
                this.f709a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.f709a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }
    }
}
