package n2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.internal.play_billing.i0;
import k2.h;
import l2.f;
import l2.l;
/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: z  reason: collision with root package name */
    public final l f4088z;

    public e(Context context, Looper looper, l2.c cVar, l lVar, k2.c cVar2, h hVar) {
        super(context, looper, 270, cVar, cVar2, hVar);
        this.f4088z = lVar;
    }

    @Override // j2.b
    public final int g() {
        return 203400000;
    }

    @Override // l2.f
    public final /* synthetic */ IInterface i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder);
    }

    @Override // l2.f
    public final i2.c[] j() {
        return i0.f1890g;
    }

    @Override // l2.f
    public final Bundle k() {
        l lVar = this.f4088z;
        lVar.getClass();
        Bundle bundle = new Bundle();
        String str = lVar.f3869a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // l2.f
    public final String m() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // l2.f
    public final String n() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // l2.f
    public final boolean o() {
        return true;
    }
}
