package com.bumptech.glide.load.c;

import android.support.v7.widget.helper.ItemTouchHelper;
import java.util.Queue;
/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class k<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.i.e<a<A>, B> f889a;

    public k() {
        this(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public k(int i) {
        this.f889a = new com.bumptech.glide.i.e<a<A>, B>(i) { // from class: com.bumptech.glide.load.c.k.1
            @Override // com.bumptech.glide.i.e
            protected /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
                a((a) ((a) obj), (a<A>) obj2);
            }

            protected void a(a<A> aVar, B b2) {
                aVar.a();
            }
        };
    }

    public B a(A a2, int i, int i2) {
        a<A> a3 = a.a(a2, i, i2);
        B b2 = this.f889a.b((com.bumptech.glide.i.e<a<A>, B>) a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f889a.b(a.a(a2, i, i2), b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f891a = com.bumptech.glide.i.h.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f892b;

        /* renamed from: c  reason: collision with root package name */
        private int f893c;
        private A d;

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar = (a<A>) f891a.poll();
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private a() {
        }

        private void b(A a2, int i, int i2) {
            this.d = a2;
            this.f893c = i;
            this.f892b = i2;
        }

        public void a() {
            f891a.offer(this);
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f893c == aVar.f893c && this.f892b == aVar.f892b && this.d.equals(aVar.d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f892b * 31) + this.f893c) * 31) + this.d.hashCode();
        }
    }
}
