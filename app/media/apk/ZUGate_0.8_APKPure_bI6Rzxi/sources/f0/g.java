package f0;
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2737a;

    public abstract boolean a();

    public final boolean b(CharSequence charSequence, int i5) {
        if (charSequence == null || i5 < 0 || charSequence.length() - i5 < 0) {
            throw new IllegalArgumentException();
        }
        f fVar = (f) this.f2737a;
        if (fVar == null) {
            return a();
        }
        int b5 = fVar.b(charSequence, i5);
        if (b5 != 0) {
            if (b5 != 1) {
                return a();
            }
            return false;
        }
        return true;
    }
}
