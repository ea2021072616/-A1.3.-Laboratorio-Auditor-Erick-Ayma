package l;
/* loaded from: classes.dex */
public final class a extends h.d {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3663j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f3664k;

    public /* synthetic */ a(int i5, Object obj) {
        this.f3663j = i5;
        this.f3664k = obj;
    }

    @Override // h.d
    public final void c() {
        int i5 = this.f3663j;
        Object obj = this.f3664k;
        switch (i5) {
            case 0:
                ((b) obj).clear();
                return;
            default:
                ((c) obj).clear();
                return;
        }
    }

    @Override // h.d
    public final Object d(int i5, int i6) {
        int i7 = this.f3663j;
        Object obj = this.f3664k;
        switch (i7) {
            case 0:
                return ((b) obj).f3704c[(i5 << 1) + i6];
            default:
                return ((c) obj).f3673c[i5];
        }
    }

    @Override // h.d
    public final b e() {
        switch (this.f3663j) {
            case 0:
                return (b) this.f3664k;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    @Override // h.d
    public final int f() {
        int i5 = this.f3663j;
        Object obj = this.f3664k;
        switch (i5) {
            case 0:
                return ((b) obj).f3705d;
            default:
                return ((c) obj).f3674d;
        }
    }

    @Override // h.d
    public final int g(Object obj) {
        int i5 = this.f3663j;
        Object obj2 = this.f3664k;
        switch (i5) {
            case 0:
                return ((b) obj2).e(obj);
            default:
                return ((c) obj2).indexOf(obj);
        }
    }

    @Override // h.d
    public final int h(Object obj) {
        int i5 = this.f3663j;
        Object obj2 = this.f3664k;
        switch (i5) {
            case 0:
                return ((b) obj2).g(obj);
            default:
                return ((c) obj2).indexOf(obj);
        }
    }

    @Override // h.d
    public final void i(Object obj, Object obj2) {
        int i5 = this.f3663j;
        Object obj3 = this.f3664k;
        switch (i5) {
            case 0:
                ((b) obj3).put(obj, obj2);
                return;
            default:
                ((c) obj3).add(obj);
                return;
        }
    }

    @Override // h.d
    public final void j(int i5) {
        int i6 = this.f3663j;
        Object obj = this.f3664k;
        switch (i6) {
            case 0:
                ((b) obj).i(i5);
                return;
            default:
                ((c) obj).i(i5);
                return;
        }
    }

    @Override // h.d
    public final Object k(int i5, Object obj) {
        switch (this.f3663j) {
            case 0:
                int i6 = (i5 << 1) + 1;
                Object[] objArr = ((b) this.f3664k).f3704c;
                Object obj2 = objArr[i6];
                objArr[i6] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }
}
