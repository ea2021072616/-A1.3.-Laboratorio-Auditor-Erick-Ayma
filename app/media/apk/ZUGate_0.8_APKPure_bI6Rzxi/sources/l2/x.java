package l2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
/* loaded from: classes.dex */
public final class x extends s2.a {

    /* renamed from: a  reason: collision with root package name */
    public f f3897a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3898b;

    public x(f fVar, int i5) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f3897a = fVar;
        this.f3898b = i5;
    }

    @Override // s2.a
    public final boolean a(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 == 1) {
            s2.b.b(parcel);
            com.google.android.gms.internal.play_billing.i0.i(this.f3897a, "onPostInitComplete can be called only once per call to getRemoteService");
            f fVar = this.f3897a;
            fVar.getClass();
            z zVar = new z(fVar, parcel.readInt(), parcel.readStrongBinder(), (Bundle) s2.b.a(parcel, Bundle.CREATOR));
            w wVar = fVar.f3811e;
            wVar.sendMessage(wVar.obtainMessage(1, this.f3898b, -1, zVar));
            this.f3897a = null;
        } else if (i5 == 2) {
            parcel.readInt();
            Bundle bundle = (Bundle) s2.b.a(parcel, Bundle.CREATOR);
            s2.b.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else if (i5 != 3) {
            return false;
        } else {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            b0 b0Var = (b0) s2.b.a(parcel, b0.CREATOR);
            s2.b.b(parcel);
            f fVar2 = this.f3897a;
            com.google.android.gms.internal.play_billing.i0.i(fVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            com.google.android.gms.internal.play_billing.i0.j(b0Var);
            fVar2.f3826u = b0Var;
            Bundle bundle2 = b0Var.f3762b;
            com.google.android.gms.internal.play_billing.i0.i(this.f3897a, "onPostInitComplete can be called only once per call to getRemoteService");
            f fVar3 = this.f3897a;
            fVar3.getClass();
            z zVar2 = new z(fVar3, readInt, readStrongBinder, bundle2);
            w wVar2 = fVar3.f3811e;
            wVar2.sendMessage(wVar2.obtainMessage(1, this.f3898b, -1, zVar2));
            this.f3897a = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
