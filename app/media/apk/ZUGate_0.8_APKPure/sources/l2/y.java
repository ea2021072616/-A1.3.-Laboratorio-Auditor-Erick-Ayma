package l2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public final class y implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final int f3899a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f3900b;

    public y(f fVar, int i5) {
        this.f3900b = fVar;
        this.f3899a = i5;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i5;
        int i6;
        f fVar = this.f3900b;
        if (iBinder == null) {
            synchronized (fVar.f3812f) {
                i5 = fVar.f3819m;
            }
            if (i5 == 3) {
                fVar.f3825t = true;
                i6 = 5;
            } else {
                i6 = 4;
            }
            w wVar = fVar.f3811e;
            wVar.sendMessage(wVar.obtainMessage(i6, fVar.f3827v.get(), 16));
            return;
        }
        synchronized (fVar.f3813g) {
            f fVar2 = this.f3900b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            fVar2.f3814h = (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new u(iBinder) : (u) queryLocalInterface;
        }
        f fVar3 = this.f3900b;
        int i7 = this.f3899a;
        fVar3.getClass();
        a0 a0Var = new a0(fVar3, 0);
        w wVar2 = fVar3.f3811e;
        wVar2.sendMessage(wVar2.obtainMessage(7, i7, -1, a0Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        f fVar;
        synchronized (this.f3900b.f3813g) {
            fVar = this.f3900b;
            fVar.f3814h = null;
        }
        int i5 = this.f3899a;
        w wVar = fVar.f3811e;
        wVar.sendMessage(wVar.obtainMessage(6, i5, 1));
    }
}
