package b4;
/* loaded from: classes.dex */
public abstract class d extends e4.e {
    public static final void k0(Object[] objArr, Object[] objArr2, int i5, int i6, int i7) {
        e4.e.f(objArr, "<this>");
        e4.e.f(objArr2, "destination");
        System.arraycopy(objArr, i6, objArr2, i5, i7 - i6);
    }

    public static /* synthetic */ void l0(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        k0(objArr, objArr2, i5, i6, i7);
    }
}
