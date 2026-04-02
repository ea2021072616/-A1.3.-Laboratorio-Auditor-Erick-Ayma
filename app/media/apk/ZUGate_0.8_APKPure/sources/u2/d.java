package u2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.appcompat.widget.k;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import k2.x;
/* loaded from: classes.dex */
public abstract class d extends Binder implements e, IInterface {
    public d() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    /* renamed from: d */
    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        switch (i5) {
            case 3:
                i2.a aVar = (i2.a) r2.b.a(parcel, i2.a.CREATOR);
                b bVar = (b) r2.b.a(parcel, b.CREATOR);
                r2.b.b(parcel);
                break;
            case 4:
                Status status = (Status) r2.b.a(parcel, Status.CREATOR);
                r2.b.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                Status status2 = (Status) r2.b.a(parcel, Status.CREATOR);
                r2.b.b(parcel);
                break;
            case 7:
                Status status3 = (Status) r2.b.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) r2.b.a(parcel, GoogleSignInAccount.CREATOR);
                r2.b.b(parcel);
                break;
            case 8:
                r2.b.b(parcel);
                x xVar = (x) this;
                xVar.f3630b.post(new k(xVar, 11, (i) r2.b.a(parcel, i.CREATOR)));
                break;
            case 9:
                g gVar = (g) r2.b.a(parcel, g.CREATOR);
                r2.b.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
