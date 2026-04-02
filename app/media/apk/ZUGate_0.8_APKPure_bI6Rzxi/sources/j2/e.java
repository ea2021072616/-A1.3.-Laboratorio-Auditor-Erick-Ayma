package j2;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.internal.play_billing.i0;
import java.util.Collections;
import java.util.Set;
import l2.l;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3442a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3443b;

    /* renamed from: c  reason: collision with root package name */
    public final d.e f3444c;

    /* renamed from: d  reason: collision with root package name */
    public final a f3445d;

    /* renamed from: e  reason: collision with root package name */
    public final k2.a f3446e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3447f;

    /* renamed from: g  reason: collision with root package name */
    public final z0.d f3448g;

    /* renamed from: h  reason: collision with root package name */
    public final k2.d f3449h;

    public e(Context context, d.e eVar, d dVar) {
        l lVar = l.f3868b;
        if (context == null) {
            throw new NullPointerException("Null context is not permitted.");
        }
        if (eVar == null) {
            throw new NullPointerException("Api must not be null.");
        }
        if (dVar == null) {
            throw new NullPointerException("Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        }
        Context applicationContext = context.getApplicationContext();
        i0.i(applicationContext, "The provided context did not have an application context.");
        this.f3442a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f3443b = attributionTag;
        this.f3444c = eVar;
        this.f3445d = lVar;
        this.f3446e = new k2.a(eVar, attributionTag);
        k2.d e5 = k2.d.e(applicationContext);
        this.f3449h = e5;
        this.f3447f = e5.f3584h.getAndIncrement();
        this.f3448g = dVar.f3441a;
        r2.d dVar2 = e5.f3589m;
        dVar2.sendMessage(dVar2.obtainMessage(7, this));
    }

    public final androidx.fragment.app.g a() {
        androidx.fragment.app.g gVar = new androidx.fragment.app.g(4);
        gVar.f889g = null;
        Set emptySet = Collections.emptySet();
        if (((l.c) gVar.f890h) == null) {
            gVar.f890h = new l.c(0);
        }
        ((l.c) gVar.f890h).addAll(emptySet);
        Context context = this.f3442a;
        gVar.f892j = context.getClass().getName();
        gVar.f891i = context.getPackageName();
        return gVar;
    }
}
