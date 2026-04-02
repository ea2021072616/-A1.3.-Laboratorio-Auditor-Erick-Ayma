package r2;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f4487a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4488b;

    public a(IBinder iBinder, String str) {
        this.f4487a = iBinder;
        this.f4488b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4487a;
    }
}
