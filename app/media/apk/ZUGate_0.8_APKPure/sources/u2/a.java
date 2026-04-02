package u2;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.k;
import androidx.recyclerview.widget.b0;
import b4.j;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.play_billing.i0;
import java.util.concurrent.locks.ReentrantLock;
import k2.x;
import l2.q;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class a extends l2.f implements t2.c {
    public final l2.c A;
    public final Bundle B;
    public final Integer C;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f5136z;

    public a(Context context, Looper looper, l2.c cVar, Bundle bundle, j2.f fVar, j2.g gVar) {
        super(context, looper, 44, cVar, fVar, gVar);
        this.f5136z = true;
        this.A = cVar;
        this.B = bundle;
        this.C = cVar.f3772g;
    }

    @Override // t2.c
    public final void c(e eVar) {
        GoogleSignInAccount googleSignInAccount;
        if (eVar == null) {
            throw new NullPointerException("Expecting a valid ISignInCallbacks");
        }
        try {
            Account account = this.A.f3766a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            if ("<<default account>>".equals(account.name)) {
                h2.a a5 = h2.a.a(this.f3809c);
                ReentrantLock reentrantLock = a5.f3347a;
                reentrantLock.lock();
                String string = a5.f3348b.getString("defaultGoogleSignInAccount", null);
                reentrantLock.unlock();
                if (!TextUtils.isEmpty(string)) {
                    String str = "googleSignInAccount:" + string;
                    ReentrantLock reentrantLock2 = a5.f3347a;
                    reentrantLock2.lock();
                    String string2 = a5.f3348b.getString(str, null);
                    reentrantLock2.unlock();
                    if (string2 != null) {
                        try {
                            googleSignInAccount = GoogleSignInAccount.a(string2);
                        } catch (JSONException unused) {
                        }
                        Integer num = this.C;
                        i0.j(num);
                        q qVar = new q(2, account, num.intValue(), googleSignInAccount);
                        f fVar = (f) l();
                        Parcel obtain = Parcel.obtain();
                        obtain.writeInterfaceToken(fVar.f4488b);
                        int i5 = r2.b.f4489a;
                        obtain.writeInt(1);
                        int o02 = j.o0(obtain, 20293);
                        j.h0(obtain, 1, 1);
                        j.i0(obtain, 2, qVar, 0);
                        j.t0(obtain, o02);
                        obtain.writeStrongBinder((d) eVar);
                        Parcel obtain2 = Parcel.obtain();
                        fVar.f4487a.transact(12, obtain, obtain2, 0);
                        obtain2.readException();
                        obtain.recycle();
                        obtain2.recycle();
                    }
                }
            }
            googleSignInAccount = null;
            Integer num2 = this.C;
            i0.j(num2);
            q qVar2 = new q(2, account, num2.intValue(), googleSignInAccount);
            f fVar2 = (f) l();
            Parcel obtain3 = Parcel.obtain();
            obtain3.writeInterfaceToken(fVar2.f4488b);
            int i52 = r2.b.f4489a;
            obtain3.writeInt(1);
            int o022 = j.o0(obtain3, 20293);
            j.h0(obtain3, 1, 1);
            j.i0(obtain3, 2, qVar2, 0);
            j.t0(obtain3, o022);
            obtain3.writeStrongBinder((d) eVar);
            Parcel obtain22 = Parcel.obtain();
            fVar2.f4487a.transact(12, obtain3, obtain22, 0);
            obtain22.readException();
            obtain3.recycle();
            obtain22.recycle();
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                x xVar = (x) eVar;
                xVar.f3630b.post(new k(xVar, 11, new i(1, new i2.a(8, null), null)));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }

    @Override // l2.f, j2.b
    public final boolean e() {
        return this.f5136z;
    }

    @Override // t2.c
    public final void f() {
        this.f3815i = new b0(this);
        s(2, null);
    }

    @Override // j2.b
    public final int g() {
        return 12451000;
    }

    @Override // l2.f
    public final /* synthetic */ IInterface i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new f(iBinder);
    }

    @Override // l2.f
    public final Bundle k() {
        l2.c cVar = this.A;
        boolean equals = this.f3809c.getPackageName().equals(cVar.f3769d);
        Bundle bundle = this.B;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", cVar.f3769d);
        }
        return bundle;
    }

    @Override // l2.f
    public final String m() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // l2.f
    public final String n() {
        return "com.google.android.gms.signin.service.START";
    }
}
