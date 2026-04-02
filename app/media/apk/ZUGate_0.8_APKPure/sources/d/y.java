package d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: g  reason: collision with root package name */
    public static final w f2482g = new w(new x());

    /* renamed from: h  reason: collision with root package name */
    public static int f2483h = -100;

    /* renamed from: i  reason: collision with root package name */
    public static d0.g f2484i = null;

    /* renamed from: j  reason: collision with root package name */
    public static d0.g f2485j = null;

    /* renamed from: k  reason: collision with root package name */
    public static Boolean f2486k = null;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f2487l = false;

    /* renamed from: m  reason: collision with root package name */
    public static final l.c f2488m = new l.c(0);

    /* renamed from: n  reason: collision with root package name */
    public static final Object f2489n = new Object();
    public static final Object o = new Object();

    public static boolean f(Context context) {
        if (f2486k == null) {
            try {
                int i5 = t0.f2461g;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, t0.class), s0.a() | 128).metaData;
                if (bundle != null) {
                    f2486k = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f2486k = Boolean.FALSE;
            }
        }
        return f2486k.booleanValue();
    }

    public static void i(y yVar) {
        synchronized (f2489n) {
            Iterator it = f2488m.iterator();
            while (it.hasNext()) {
                y yVar2 = (y) ((WeakReference) it.next()).get();
                if (yVar2 == yVar || yVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void b();

    public abstract void e();

    public abstract void g();

    public abstract void h();

    public abstract boolean j(int i5);

    public abstract void k(int i5);

    public abstract void l(View view);

    public abstract void m(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void n(CharSequence charSequence);

    public abstract g.b o(g.a aVar);
}
