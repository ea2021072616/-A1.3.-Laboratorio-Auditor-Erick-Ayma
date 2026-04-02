package l2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
/* loaded from: classes.dex */
public final class z extends s {

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f3901g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ f f3902h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(f fVar, int i5, IBinder iBinder, Bundle bundle) {
        super(fVar, i5, bundle);
        this.f3902h = fVar;
        this.f3901g = iBinder;
    }

    @Override // l2.s
    public final void b(i2.a aVar) {
        androidx.recyclerview.widget.b0 b0Var = this.f3902h.o;
        if (b0Var != null) {
            ((k2.h) b0Var.f1296g).a(aVar);
        }
        System.currentTimeMillis();
    }

    @Override // l2.s
    public final boolean c() {
        IBinder iBinder = this.f3901g;
        try {
            com.google.android.gms.internal.play_billing.i0.j(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            f fVar = this.f3902h;
            if (!fVar.m().equals(interfaceDescriptor)) {
                String m5 = fVar.m();
                Log.w("GmsClient", "service descriptor mismatch: " + m5 + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface i5 = fVar.i(iBinder);
            if (i5 == null || !(f.r(fVar, 2, 4, i5) || f.r(fVar, 3, 4, i5))) {
                return false;
            }
            fVar.f3824s = null;
            androidx.recyclerview.widget.b0 b0Var = fVar.f3820n;
            if (b0Var != null) {
                ((k2.c) b0Var.f1296g).c();
                return true;
            }
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
