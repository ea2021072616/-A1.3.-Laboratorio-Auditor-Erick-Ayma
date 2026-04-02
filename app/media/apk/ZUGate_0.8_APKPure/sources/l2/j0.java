package l2;

import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class j0 extends s2.a implements t {
    public j0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // s2.a
    public final boolean a(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 == 1) {
            q2.a aVar = new q2.a(((i2.l) this).c());
            parcel2.writeNoException();
            int i6 = s2.b.f4859a;
            parcel2.writeStrongBinder(aVar);
        } else if (i5 != 2) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(((i2.l) this).f3404a);
        }
        return true;
    }
}
