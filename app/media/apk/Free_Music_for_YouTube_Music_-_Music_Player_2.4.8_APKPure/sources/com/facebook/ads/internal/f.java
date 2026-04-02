package com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.facebook.ads.internal.util.g;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1308a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final String f1309b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1310c;
    private final c d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f1314a;

        a(IBinder iBinder) {
            this.f1314a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f1314a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1314a;
        }

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f1314a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private AtomicBoolean f1318a;

        /* renamed from: b  reason: collision with root package name */
        private final BlockingQueue<IBinder> f1319b;

        private b() {
            this.f1318a = new AtomicBoolean(false);
            this.f1319b = new LinkedBlockingDeque();
        }

        public IBinder a() {
            if (this.f1318a.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            return this.f1319b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f1319b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    private f(String str, boolean z, c cVar) {
        this.f1309b = str;
        this.f1310c = z;
        this.d = cVar;
    }

    private static f a(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new f(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled(), c.DIRECT);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static f a(Context context, g.a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        }
        if (aVar == null || TextUtils.isEmpty(aVar.f1531b)) {
            f a2 = a(context);
            if (a2 == null || TextUtils.isEmpty(a2.a())) {
                a2 = b(context);
            }
            return (a2 == null || TextUtils.isEmpty(a2.a())) ? c(context) : a2;
        }
        return new f(aVar.f1531b, aVar.f1532c, c.FB4A);
    }

    private static f b(Context context) {
        Object a2;
        Method a3 = com.facebook.ads.internal.util.g.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a3 == null) {
            return null;
        }
        Object a4 = com.facebook.ads.internal.util.g.a((Object) null, a3, context);
        if (a4 == null || ((Integer) a4).intValue() != 0) {
            return null;
        }
        Method a5 = com.facebook.ads.internal.util.g.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a5 != null && (a2 = com.facebook.ads.internal.util.g.a((Object) null, a5, context)) != null) {
            Method a6 = com.facebook.ads.internal.util.g.a(a2.getClass(), "getId", new Class[0]);
            Method a7 = com.facebook.ads.internal.util.g.a(a2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (a6 == null || a7 == null) {
                return null;
            }
            return new f((String) com.facebook.ads.internal.util.g.a(a2, a6, new Object[0]), ((Boolean) com.facebook.ads.internal.util.g.a(a2, a7, new Object[0])).booleanValue(), c.REFLECTION);
        }
        return null;
    }

    private static f c(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                a aVar = new a(bVar.a());
                return new f(aVar.a(), aVar.b(), c.SERVICE);
            } catch (Exception e) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    public String a() {
        return this.f1309b;
    }

    public boolean b() {
        return this.f1310c;
    }

    public c c() {
        return this.d;
    }
}
