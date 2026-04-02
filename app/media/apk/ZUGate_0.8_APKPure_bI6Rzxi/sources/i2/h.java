package i2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.internal.play_billing.i0;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class h implements androidx.emoji2.text.l {

    /* renamed from: b  reason: collision with root package name */
    public static h f3396b;

    /* renamed from: a  reason: collision with root package name */
    public Context f3397a;

    public static final l b(PackageInfo packageInfo, l... lVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            m mVar = new m(packageInfo.signatures[0].toByteArray());
            for (int i5 = 0; i5 < lVarArr.length; i5++) {
                if (lVarArr[i5].equals(mVar)) {
                    return lVarArr[i5];
                }
            }
        }
        return null;
    }

    public static final boolean c(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z4;
        ApplicationInfo applicationInfo;
        if (packageInfo != null) {
            z4 = (("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) && ((applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 129) == 0)) ? false : true;
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
            z4 = true;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z4 ? b(packageInfo2, o.f3408a) : b(packageInfo2, o.f3408a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.emoji2.text.l
    public final void a(final b4.j jVar) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Runnable() { // from class: androidx.emoji2.text.o
            @Override // java.lang.Runnable
            public final void run() {
                i2.h hVar = i2.h.this;
                b4.j jVar2 = jVar;
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                hVar.getClass();
                try {
                    n n5 = i0.n(hVar.f3397a);
                    if (n5 == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    z zVar = (z) n5.f765a;
                    synchronized (zVar.f807d) {
                        zVar.f809f = threadPoolExecutor2;
                    }
                    n5.f765a.a(new p(jVar2, threadPoolExecutor2));
                } catch (Throwable th) {
                    jVar2.E(th);
                    threadPoolExecutor2.shutdown();
                }
            }
        });
    }

    public h(Context context, int i5) {
        if (i5 == 2) {
            this.f3397a = context.getApplicationContext();
        } else if (i5 != 4) {
            this.f3397a = context.getApplicationContext();
        } else {
            this.f3397a = context.getApplicationContext();
        }
    }
}
