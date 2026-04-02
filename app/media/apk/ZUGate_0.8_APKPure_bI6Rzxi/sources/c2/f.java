package c2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import java.util.Objects;
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f1726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x1.i f1727c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1728d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Runnable f1729e;

    public /* synthetic */ f(k kVar, x1.i iVar, int i5, Runnable runnable) {
        this.f1726b = kVar;
        this.f1727c = iVar;
        this.f1728d = i5;
        this.f1729e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x1.i iVar = this.f1727c;
        int i5 = this.f1728d;
        Runnable runnable = this.f1729e;
        k kVar = this.f1726b;
        n nVar = kVar.f1746d;
        e2.c cVar = kVar.f1748f;
        try {
            try {
                d2.d dVar = kVar.f1745c;
                Objects.requireNonNull(dVar);
                ((d2.k) cVar).J(new w.g(3, dVar));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) kVar.f1743a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    kVar.a(iVar, i5);
                } else {
                    d2.k kVar2 = (d2.k) cVar;
                    SQLiteDatabase j5 = kVar2.j();
                    h0.h hVar = new h0.h(12);
                    f2.b bVar = (f2.b) kVar2.f2531d;
                    long a5 = bVar.a();
                    while (true) {
                        try {
                            j5.beginTransaction();
                            break;
                        } catch (SQLiteDatabaseLockedException e5) {
                            if (bVar.a() >= kVar2.f2532e.f2510c + a5) {
                                hVar.a(e5);
                                break;
                            }
                            SystemClock.sleep(50L);
                        }
                    }
                    try {
                        ((d) nVar).a(iVar, i5 + 1, false);
                        j5.setTransactionSuccessful();
                        j5.endTransaction();
                    } catch (Throwable th) {
                        j5.endTransaction();
                        throw th;
                    }
                }
            } finally {
                runnable.run();
            }
        } catch (e2.a unused) {
            ((d) nVar).a(iVar, i5 + 1, false);
        }
    }
}
