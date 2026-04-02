package n;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4024a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f4025b;

    /* renamed from: c  reason: collision with root package name */
    public int f4026c;

    public e(int i5, int i6) {
        this.f4024a = i6;
        if (i6 != 1) {
            if (i5 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f4025b = new Object[i5];
            return;
        }
        if (!(i5 > 0)) {
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }
        this.f4025b = new Object[i5];
    }

    public Object a() {
        int i5 = this.f4024a;
        Object[] objArr = this.f4025b;
        switch (i5) {
            case 0:
                int i6 = this.f4026c;
                if (i6 > 0) {
                    int i7 = i6 - 1;
                    Object obj = objArr[i7];
                    objArr[i7] = null;
                    this.f4026c = i7;
                    return obj;
                }
                return null;
            default:
                int i8 = this.f4026c;
                if (i8 > 0) {
                    int i9 = i8 - 1;
                    Object obj2 = objArr[i9];
                    e4.e.d(obj2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                    objArr[i9] = null;
                    this.f4026c--;
                    return obj2;
                }
                return null;
        }
    }

    public boolean b(Object obj) {
        boolean z4;
        int i5 = this.f4024a;
        Object[] objArr = this.f4025b;
        switch (i5) {
            case 0:
                int i6 = this.f4026c;
                if (i6 < objArr.length) {
                    objArr[i6] = obj;
                    this.f4026c = i6 + 1;
                    return true;
                }
                return false;
            default:
                e4.e.f(obj, "instance");
                int i7 = this.f4026c;
                int i8 = 0;
                while (true) {
                    if (i8 >= i7) {
                        z4 = false;
                    } else if (objArr[i8] == obj) {
                        z4 = true;
                    } else {
                        i8++;
                    }
                }
                if (!z4) {
                    int i9 = this.f4026c;
                    if (i9 < objArr.length) {
                        objArr[i9] = obj;
                        this.f4026c = i9 + 1;
                        return true;
                    }
                    return false;
                }
                throw new IllegalStateException("Already in the pool!".toString());
        }
    }
}
