package b.a.a.a.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvertisingInfoServiceStrategy.java */
/* loaded from: classes.dex */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f93a;

    public e(Context context) {
        this.f93a = context.getApplicationContext();
    }

    @Override // b.a.a.a.a.b.f
    public b.a.a.a.a.b.b a() {
        b.a.a.a.a.b.b bVar = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b.a.a.a.c.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
        } else {
            try {
                this.f93a.getPackageManager().getPackageInfo(zzo.GOOGLE_PLAY_STORE_PACKAGE, 0);
                a aVar = new a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (this.f93a.bindService(intent, aVar, 1)) {
                        try {
                            b bVar2 = new b(aVar.a());
                            b.a.a.a.a.b.b bVar3 = new b.a.a.a.a.b.b(bVar2.a(), bVar2.b());
                            this.f93a.unbindService(aVar);
                            bVar = bVar3;
                        } catch (Exception e) {
                            b.a.a.a.c.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                            this.f93a.unbindService(aVar);
                        }
                    } else {
                        b.a.a.a.c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                    }
                } catch (Throwable th) {
                    b.a.a.a.c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                b.a.a.a.c.h().a("Fabric", "Unable to find Google Play Services package name");
            } catch (Exception e3) {
                b.a.a.a.c.h().a("Fabric", "Unable to determine if Google Play Services is available", e3);
            }
        }
        return bVar;
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* loaded from: classes.dex */
    private static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private boolean f94a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f95b;

        private a() {
            this.f94a = false;
            this.f95b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f95b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f95b.clear();
        }

        public IBinder a() {
            if (this.f94a) {
                b.a.a.a.c.h().e("Fabric", "getBinder already called");
            }
            this.f94a = true;
            try {
                return this.f95b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* loaded from: classes.dex */
    private static final class b implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private final IBinder f96a;

        public b(IBinder iBinder) {
            this.f96a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f96a;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f96a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                b.a.a.a.c.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }

        public boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(1);
                    this.f96a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    boolean z = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Exception e) {
                    b.a.a.a.c.h().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                    obtain2.recycle();
                    obtain.recycle();
                    return false;
                }
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }
}
